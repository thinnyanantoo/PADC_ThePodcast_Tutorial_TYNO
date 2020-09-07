package com.example.padc_thepodcast_tutorial_tyno.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.adapters.CategorySearchRecyclerAdapter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls.SearchPresenterImpl
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.SearchPresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.SearchView
import com.example.padc_thepodcast_tutorial_tyno.utils.EMPTY_IMAGE_URL
import com.example.padc_thepodcast_tutorial_tyno.utils.EM_NO_PODCAST_AVAILABLE
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.CategorySearchViewPod
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.categories_recyclerview_view_pod.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.swipeRefreshLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment(), SearchView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var mcategorySearchAdapter: CategorySearchRecyclerAdapter
    private lateinit var mCategoryViewPod: CategorySearchViewPod
    private lateinit var mPresenter: SearchPresenter
    private lateinit var mViewPodEmpty : EmptyViewPod
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // hideEmptyView()
        mCategoryViewPod = vpCategorySearch as CategorySearchViewPod
        setUpPresenter()
        setUpRecycler()
        //setUpEmptyViewPod()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(activity!!).get(SearchPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mcategorySearchAdapter = CategorySearchRecyclerAdapter()
    }

    private fun setUpEmptyViewPod(){
//        mViewPodEmpty = vpEmpty as EmptyViewPod
//        mViewPodEmpty.setEmptyData(EM_NO_PODCAST_AVAILABLE, EMPTY_IMAGE_URL)
//        mViewPodEmpty.setDelegate(mPresenter)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun showGenereList(genereList: List<GenereVO>) {
        mCategoryViewPod.bindAdapter(mcategorySearchAdapter, genereList.toMutableList())
    }

    override fun showGenere(genereVO: GenereVO) {
        tvCategoryName.text = genereVO.name
    }

    override fun displayEmptyView() {
//      vpEmpty.visibility = View.VISIBLE
    }

    override fun hideEmptyView() {
//        vpEmpty.visibility = View.GONE
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true

    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }
}