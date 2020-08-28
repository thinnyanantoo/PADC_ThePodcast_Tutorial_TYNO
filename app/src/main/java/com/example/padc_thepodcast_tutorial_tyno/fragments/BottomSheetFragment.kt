package com.example.padc_thepodcast_tutorial_tyno.fragments

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.padc_thepodcast_tutorial_tyno.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.coroutines.coroutineContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomSheetFragment : BottomSheetDialogFragment() {

    companion object {
        const val BOTTOM_SHEET_TAG = "BOTTOM_SHEET_TAG"

        fun newInstance(): BottomSheetFragment {
            return BottomSheetFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.empty_bottom_sheet,container,false)
        return view

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as
                    BottomSheetDialog
            setupFullHeight(bottomSheetDialog)
        }
        return dialog
    }

        private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
            val bottomSheet =
                bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
            val behavior: BottomSheetBehavior<*> =
                BottomSheetBehavior.from<FrameLayout?>(bottomSheet!!)
            val layoutParams = bottomSheet.layoutParams
            val windowHeight = getWindowHeight()
            if (layoutParams != null) {
                layoutParams.height = windowHeight
            }
            bottomSheet.layoutParams = layoutParams
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }


        private fun getWindowHeight(): Int {
            // Calculate window height for fullscreen use
            val displayMetrics = DisplayMetrics()
            (context as Activity?)!!.windowManager.defaultDisplay
                .getMetrics(displayMetrics)
            return displayMetrics.heightPixels
        }
    }

