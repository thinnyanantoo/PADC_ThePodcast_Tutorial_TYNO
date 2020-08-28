package com.example.padc_thepodcast_tutorial_tyno.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_thepodcast_tutorial_tyno.Delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.activities.DetailActivity
import com.example.padc_thepodcast_tutorial_tyno.adapters.UpNextHomeRecyclerAdapter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.MainView
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.UpNextHomeViewPod
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.play_back_view_pod.*
import kotlinx.android.synthetic.main.play_back_view_pod.straightProgress
import kotlinx.android.synthetic.main.rv_item_up_next_home.*
import kotlinx.android.synthetic.main.up_next_home_recycler_view_pod.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() , MainView , ItemDelegate{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    private lateinit var mupNextViewPod : UpNextHomeViewPod
    private val mupNextAdapter : UpNextHomeRecyclerAdapter = UpNextHomeRecyclerAdapter(this)

    override fun onTapItem() {
        context?.let {
            startActivity(DetailActivity.newIntent(it))
        }
    }

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mupNextViewPod = vpUpNext as UpNextHomeViewPod
        setUpRecycler()

      //  straightProgress.progressSet = 70
      //  straightProgressUpNext.progressSet = 60

        disableSwipeRefresh()

    }

    private fun setUpRecycler(){
        mupNextViewPod.bindAdapter(mupNextAdapter)
   }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun navigateToDetailActivity(podCastId : Int) {
        context?.let {
            startActivity(DetailActivity.newIntent(it))
        }
    }

    override fun displayEmptyView() {
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun disableSwipeRefresh() {
       swipeRefreshLayout.isRefreshing = true
    }
}