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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.crystal.movieapp.features.feed.presentation.output.FeedUiEffect
import com.crystal.movieapp.features.feed.presentation.screen.FeedScreen
import com.crystal.movieapp.features.feed.presentation.viewmodel.FeedViewModel
import com.crystal.movieapp.ui.components.navigation.safeNavigate
import com.crystal.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeUiEffects()
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
    private fun observeUiEffects() {
        val navController = findNavController()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.output.feedUiEffect.collectLatest {
                    when (it) {
                        is FeedUiEffect.OpenMovieDetail -> {
                            navController.safeNavigate(
                                FeedFragmentDirections.actionFeedToDetail(it.movieName)
                            )
                        }

                        is FeedUiEffect.OpenInfoDialog -> {
//                            navController.safeNavigate(
//                                FeedFragmentDirections.actionFeedToInfo()
//                            )
                        }
                    }
                }
            }
        }
    }

}