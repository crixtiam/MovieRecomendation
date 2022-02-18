package com.example.movierecomendation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movierecomendation.Data.Remote.MoviesDataSource
import com.example.movierecomendation.Domain.MoviePostRepoImpo
import com.example.movierecomendation.Presentation.MoviesPostViewModel
import com.example.movierecomendation.R
import com.example.movierecomendation.databinding.FragmentHomeBinding
import com.example.movierecomendation.ui.home.Adapters.MovieAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var Adapter : MovieAdapter
    private lateinit var binding: FragmentHomeBinding


    private val viewModel by viewModels<MoviesPostViewModel> {
        MoviesPostViewModel.MoviePostViewmodelFactory(MoviePostRepoImpo(MoviesDataSource()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.rvPostList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPostList.addItemDecoration(DividerItemDecoration(requireContext(),
            DividerItemDecoration.VERTICAL))

    }

}