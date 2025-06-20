package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.adapter.FilmlerAdapter
import com.example.filmlerapp.ui.viewmodel.AnasayfaViewModel


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    private val viewModel: AnasayfaViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)

        binding.anasayfaToolbarBaslik = "Filmler"


        viewModel.filmlerlistesi.observe(viewLifecycleOwner){
            val filmlerAdapter = FilmlerAdapter(requireContext(), it)
            binding.filmlerAdapter = filmlerAdapter
        }


        return binding.root

    }


}
