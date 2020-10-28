package com.example.loadposter.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loadposter.R
import com.example.loadposter.databinding.PosterListFragmentBinding
import com.example.loadposter.models.PosterData
import com.example.loadposter.ui.adapters.PosterListAdapter
import com.example.loadposter.viewmodels.PosterListViewModel

/**
 * Displays movie posters in a 3 column grid view.
 */
class PosterListFragment : Fragment() {

    private lateinit var viewModel: PosterListViewModel
    private lateinit var binding: PosterListFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: PosterListAdapter
    private var interactionListener: InteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.poster_list_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(PosterListViewModel::class.java)
        viewModel.posterDataLiveData.observeForever { posterDataList ->
            posterDataList?.let {
                binding.progressIndicator.visibility = View.GONE
                recyclerViewAdapter.posterList = posterDataList
                recyclerViewAdapter.notifyDataSetChanged()
            }
        }

        recyclerView = binding.recyclerView

        recyclerViewAdapter = PosterListAdapter { posterData -> run {
            viewModel.currentPosterSummary = posterData.summary
            interactionListener?.launchPosterSummaryBottomSheetFragment(posterData)
        } }

        recyclerView.apply {
            this.layoutManager = GridLayoutManager(context, 3)
            this.adapter = recyclerViewAdapter
        }

        binding.viewModel = viewModel

        viewModel.loadPosters()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        interactionListener = context as? InteractionListener
    }

    override fun onDetach() {
        super.onDetach()

        interactionListener = null
    }

    /**
     * Callback interface for poster click event.
     */
    interface InteractionListener {
        fun launchPosterSummaryBottomSheetFragment(posterData: PosterData)
    }
}