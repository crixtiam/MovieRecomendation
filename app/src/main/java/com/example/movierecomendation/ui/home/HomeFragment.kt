package com.example.movierecomendation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movierecomendation.Core.Result
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


        viewModel.fetchMoviesRecomendations().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Result.Loading->{
                    binding.progressBarMovie.visibility = View.VISIBLE
                }

                is Result.Success->{
                    Log.d("livedata", result.data.toString())
                    binding.progressBarMovie.visibility = View.INVISIBLE


                    if (result.data.isEmpty()){
                        Log.d("livedata_empty","empty livedata")
                        return@Observer
                    }

                    Adapter = MovieAdapter(result.data)
                    binding.rvPostList.adapter = Adapter
                }

                is Result.Failure->{

                }

            }
        })



    }

}