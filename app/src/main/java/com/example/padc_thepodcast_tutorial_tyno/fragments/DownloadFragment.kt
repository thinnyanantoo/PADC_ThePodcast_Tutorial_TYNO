package com.example.padc_thepodcast_tutorial_tyno.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padc_thepodcast_tutorial_tyno.Delegates.ItemDelegate
import com.example.padc_thepodcast_tutorial_tyno.R
import com.example.padc_thepodcast_tutorial_tyno.activities.DetailActivity
import com.example.padc_thepodcast_tutorial_tyno.adapters.YourShowsRecyclerAdapter
import com.example.padc_thepodcast_tutorial_tyno.mvp.views.DownloadView
import kotlinx.android.synthetic.main.fragment_download.*
import kotlinx.android.synthetic.main.fragment_reload.*
import kotlinx.android.synthetic.main.your_show_recycler_view_pod.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DownloadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DownloadFragment : Fragment(), ItemDelegate {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val myourShowAdapter: YourShowsRecyclerAdapter = YourShowsRecyclerAdapter(this)

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
        return inflater.inflate(R.layout.fragment_download, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvYourShow.layoutManager = linearLayoutManager
        rvYourShow.adapter = myourShowAdapter

        if (myourShowAdapter.itemCount == 0)
        {  showReloadView()
        }

        gotoBack()
    }


private fun gotoBack() {
    ivBack.setOnClickListener {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.frameContainer, HomeFragment.newInstance("A", "B"))
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

private fun showReloadView() {
    val fragmentTransaction = fragmentManager!!.beginTransaction()
    fragmentTransaction.replace(R.id.frameContainer, ReloadFragment.newInstance("A", "B"))
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
}
companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DownloadFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        DownloadFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
}

override fun onTapItem() {
    context?.let {
        startActivity(DetailActivity.newIntent(it))
    }
}
}

//    override fun showButtonSheetEmpty() {
//        val fragmentTransaction = fragmentManager!!.beginTransaction()
//        val emptyBottomSheetDialogFragment = BottomSheetFragment.newInstance()
//        fragmentTransaction.replace(R.id.frameContainer, BottomSheetFragment.newInstance())
//        emptyBottomSheetDialogFragment.show(fragmentTransaction, BottomSheetFragment.BOTTOM_SHEET_TAG
//        )
//        fragmentTransaction.addToBackStack(null)
//
//    }

