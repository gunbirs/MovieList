package com.example.loadposter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.loadposter.fragments.PosterListFragment
import com.example.loadposter.fragments.PosterSummaryBottomSheetFragment
import com.example.loadposter.models.PosterData

class MainActivity : AppCompatActivity(), PosterListFragment.InteractionListener {

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navController.setGraph(R.navigation.nav_graph)
    }

    override fun launchPosterSummaryBottomSheetFragment(posterData: PosterData) {
        navController.navigate(R.id.action_posterListFragment_to_posterSummaryBottomSheetFragment)
    }
}