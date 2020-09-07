package com.example.padc_thepodcast_tutorial_tyno.fragments

import android.app.Activity
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.activities.DetailActivity
import com.example.padc_thepodcast_tutorial_tyno.adapters.UpNextHomeRecyclerAdapter
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenter.HomePresenter
import com.example.padc_thepodcast_tutorial_tyno.mvp.presenters.Impls.HomePresenterImpl
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.HomeView
import com.example.padc_thepodcast_tutorial_tyno.utils.EMPTY_IMAGE_URL
import com.example.padc_thepodcast_tutorial_tyno.utils.EM_NO_PODCAST_AVAILABLE
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.EmptyViewPod
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.PlaybackHomeViewPod
import com.example.padc_thepodcast_tutorial_tyno.views.viewpods.UpNextHomeViewPod
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.play_back_view_pod.*
import java.util.jar.Manifest


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
    private lateinit var mViewPodEmpty : EmptyViewPod

    private val PERMISSION_REQUEST_CODE = 101


    private var downloadLink: String = ""
    private var mData: EpisodePlaylistVO? = null
    private var downloadId  :Long = 0

//    private val downloadReceiver = object: BroadcastReceiver() {
//        override fun onReceive(p0: Context?, p1: Intent?) {
//
//            val id = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
//
//            //Checking if the received broadcast is for our enqueued download by matching download id
//            if (downloadId == id) {
//                Toast.makeText(context, "download complete", Toast.LENGTH_SHORT).show()
//                Log.d("download complete", mData?.data!!.title)
//                mData?.data?.let { mPresenter.(it) }
//            }
//        }
//    }

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
        mPlayBackViewPod = vpPlayBack as PlaybackHomeViewPod
        mupNextViewPod = vpUpNext as UpNextHomeViewPod
        mViewPodEmpty = vpEmpty as EmptyViewPod

        hideEmptyView()
      //  setUpPlayBackViewPod()
        setUpRecycler()
       // init()
        mPresenter.onUiReady(this)
    }

    private fun setUpRecycler() {
        mupNextAdapter = UpNextHomeRecyclerAdapter(mPresenter)
    }

//    private fun init(){
//        context?.registerReceiver(downloadReceiver,IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
//    }

    private fun setUpEmptyViewPod(){
        mViewPodEmpty.setEmptyData(EM_NO_PODCAST_AVAILABLE, EMPTY_IMAGE_URL)
        mViewPodEmpty.setDelegate(mPresenter)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(activity!!).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpPlayBackViewPod(){
        mPlayBackViewPod.setDelegate(mPresenter)
    }

    override fun onDestroy() {
        mPlayBackViewPod.onDestroy()
        super.onDestroy()
    }

//    override fun onStart() {
//
//        super.onStart()
//    }

//    override fun onStop() {
//        mPlayBackViewPod.releasePlayer()
//        super.onStop()
//    }

    companion object {

        fun newInstance() = HomeFragment().apply {  }
        const val REQUEST_CODE = 100
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

    override fun navigateToDetailActivity(id: String) {
        context?.let {
            startActivity(DetailActivity.newIntent(it, id))
        }
    }

    override fun actionOnPlayTap() {
//        context.let {
//            btnPlay.visibility = View.GONE
//            btnPause.visibility = View.VISIBLE
//            mPlayBackViewPod.setPlayBackTrue()
//        }
    }


    override fun actionOnPauseTap() {
//        context.let {
//            btnPause.visibility = View.GONE
//            btnPlay.visibility = View.VISIBLE
//            mPlayBackViewPod.setPlayBackFalse()
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
        vpEmpty.visibility = View.GONE

    }

    override fun hideEmptyView() {
        vpEmpty.visibility = View.GONE

    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun selectedDownloadItem(episodePlaylistVO: EpisodePlaylistVO) {
        setUpPermissions(episodePlaylistVO)
    }

    fun setUpPermissions(episodePlaylistVO: EpisodePlaylistVO){
        val permission = ContextCompat.checkSelfPermission(
            activity as Activity,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if(permission != PackageManager.PERMISSION_GRANTED){
            makeRequest()
        } else {
            episodePlaylistVO?.let {
                mPresenter?.ondownloadItem(activity as Context, it)
            }
        }
    }

    private fun makeRequest(){
        ActivityCompat.requestPermissions(
            activity as Activity,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(activity as Activity , "Permission Denied", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(context, "Permission Granded", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

//    override fun checkResult(episodePlaylistVO: EpisodePlaylistVO) {
//        mData = episodePlaylistVO
//        when{
//            context?.let {
//                ContextCompat.checkSelfPermission(
//                    it,
//                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
//                )
//            } == PackageManager.PERMISSION_GRANTED -> {
//                context?.let {
//                    downloadId = mPresenter.download(it, mData!!)
//                }
//            }
//            else -> {
//                requestPermissions(
//                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
//                    REQUEST_CODE
//                )
//            }
//        }
//    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//            when (requestCode) {
//                REQUEST_CODE -> {
//                    if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                        context?.let {
//                            downloadId = mPresenter.download(it, mData!!)
//                        }
//                    } else {
//                        // explain user
//                    }
//                    return
//                }
//                else -> {
//
//                }
//            }
//            }
        }
