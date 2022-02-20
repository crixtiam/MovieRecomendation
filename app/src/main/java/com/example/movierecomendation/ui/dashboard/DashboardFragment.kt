package com.example.movierecomendation.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movierecomendation.Core.Result
import com.example.movierecomendation.Data.Remote.dashboard.DatasourceDashboard
import com.example.movierecomendation.Data.Remote.home.MoviesDataSource
import com.example.movierecomendation.Domain.dashboard.MovieTitleRepoImp
import com.example.movierecomendation.Domain.home.MoviePostRepoImpo
import com.example.movierecomendation.Presentation.dashboard.MoviesTotalViewModel
import com.example.movierecomendation.Presentation.home.MoviesPostViewModel
import com.example.movierecomendation.R
import com.example.movierecomendation.databinding.FragmentDashboardBinding
import com.example.movierecomendation.databinding.FragmentHomeBinding
import com.example.movierecomendation.ui.dashboard.Adapter.MovieTitleAdapter
import com.example.movierecomendation.ui.home.Adapters.MovieAdapter

class DashboardFragment : Fragment(R.layout.fragment_dashboard),MovieTitleAdapter.onClickListener {

    private lateinit var Adapter : MovieTitleAdapter
    private lateinit var binding: FragmentDashboardBinding


    private val viewModel by viewModels<MoviesTotalViewModel> {
        MoviesTotalViewModel.MoviesTotalViewmodelFactory(MovieTitleRepoImp(DatasourceDashboard()))
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDashboardBinding.bind(view)

        binding.rvTotalMovieList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTotalMovieList.addItemDecoration(
            DividerItemDecoration(requireContext(),
            DividerItemDecoration.VERTICAL)       )
        binding.rvTotalMovieList.setHasFixedSize(true)
        viewModel.fetchTotalMovies().observe(viewLifecycleOwner, Observer { result->

            when(result){
                is Result.Loading->{
                    binding.progressBarMovie.visibility = View.VISIBLE
                }

                is Result.Success->{
                    binding.progressBarMovie.visibility = View.INVISIBLE

                    if (result.data.isEmpty()){
                        Log.d("livedata_empty","empty livedata")
                        return@Observer
                    }
                    else{
                        Adapter = MovieTitleAdapter(result.data,this)
                        binding.rvTotalMovieList.adapter = Adapter
                    }


                }

                is Result.Failure->{

                }

            }
        })






    }

    override fun onClickListenerFun(identifier: Int, title: String) {
        Toast.makeText(this.context,"Te ha gustado la pelicula $title",Toast.LENGTH_LONG).show()

    }


}