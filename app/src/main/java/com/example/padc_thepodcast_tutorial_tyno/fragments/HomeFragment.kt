package com.example.padc_thepodcast_tutorial_tyno.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.activities.DetailActivity
import com.example.padc_thepodcast_tutorial_tyno.adapters.UpNextHomeRecyclerAdapter
import com.example.padc_thepodcast_tutorial_tyno.data.models.Impls.PodCastModelImpl
import com.example.padc_thepodcast_tutorial_tyno.data.models.PodCastModel
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenter.HomePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls.HomePresenterImpl
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.UpNextHomeViewPod
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), HomeView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var mPresenter: HomePresenter
    private lateinit var mupNextViewPod: UpNextHomeViewPod
    private lateinit var mPlayBackViewPod: PlaybackHomeViewPod
    private lateinit var mupNextAdapter: UpNextHomeRecyclerAdapter

    private var mModel: PodCastModel = PodCastModelImpl

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
        setUpPresenter()
        //setUpPlayBack()
        mPlayBackViewPod = vpPlayBack as PlaybackHomeViewPod
        mupNextViewPod = vpUpNext as UpNextHomeViewPod
        setUpRecycler()

        //  straightProgress.progressSet = 70
        //  straightProgressUpNext.progressSet = 60

        disableSwipeRefresh()

        mPresenter.onUiReady(this)
    }

    private fun setUpRecycler() {
        mupNextAdapter = UpNextHomeRecyclerAdapter(mPresenter)

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(activity!!).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

//    private fun setUpPlayBack() {
//        mPlayBackViewPod = vpPlayBack as PlaybackHomeViewPod
//        mPlayBackViewPod.onCreatePlayBack()
//
//    }

    override fun onDestroy() {
        mPlayBackViewPod.onDestroy()
        super.onDestroy()
    }

    override fun onStart() {

        super.onStart()
    }

    override fun onStop() {
        mPlayBackViewPod.releasePlayer()
        super.onStop()
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

    override fun navigateToDetailActivity(id : String) {
        context?.let {
            startActivity(DetailActivity.newIntent(it,id))
        }
    }

    override fun actionOnPlayTap() {
//        context.let {
//            btnPlay.visibility = View.GONE
//            btnPause.visibility = View.VISIBLE
//        }
    }

    override fun actionOnPauseTap() {
//        context.let {
//            btnPause.visibility = View.GONE
//            btnPlay.visibility = View.VISIBLE
//        }
    }

    override fun displayRandomPodCastList(podCastList: RandomPodCastVO) {

        mPlayBackViewPod.setBindData(podCastList, requireContext())
    }

    override fun displayUpNextPlayList(upNextList: List<EpisodePlaylistVO>) {
      //  mupNextViewPod = vpUpNext as UpNextHomeViewPod
        mupNextViewPod.bindAdapter(mupNextAdapter, upNextList.toMutableList())
    }

    override fun displayEmptyView() {
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }
}