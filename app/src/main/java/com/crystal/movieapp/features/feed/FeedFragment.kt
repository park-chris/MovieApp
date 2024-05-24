package com.crystal.movieapp.features.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.crystal.movieapp.features.feed.presentation.screen.FeedScreen
import com.crystal.movieapp.features.feed.presentation.viewmodel.FeedViewModel
import com.crystal.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireActivity()).apply {
            setContent {
                MovieAppTheme {
                    FeedScreen(
                        feedStateHolder = viewModel.output.feedState.collectAsState(),
                        input = viewModel.input ,
//                        buttonColor = MaterialTheme.colorScheme.background
                    )
                }
            }
        }
    }

}