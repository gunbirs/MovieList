package com.example.loadposter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.loadposter.R
import com.example.loadposter.databinding.PosterSummaryBottomSheetBinding
import com.example.loadposter.viewmodels.PosterListViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Bottom sheet fragment used to display poster summary.
 */
class PosterSummaryBottomSheetFragment: BottomSheetDialogFragment() {

    private lateinit var binding: PosterSummaryBottomSheetBinding
    private lateinit var viewModel: PosterListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL, R.style.PosterSummaryBottomSheetDialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(requireActivity()).get(PosterListViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.poster_summary_bottom_sheet, container, false)
        binding.viewModel = viewModel

        return binding.root
    }
}