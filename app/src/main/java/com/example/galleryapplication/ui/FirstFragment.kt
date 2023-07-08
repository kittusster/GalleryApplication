package com.example.galleryapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapplication.databinding.FragmentFirstBinding
import com.example.galleryapplication.ui.adapter.ImageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val mainActivityViewModel by activityViewModels<MainActivityViewModel>()
    private val binding get() = _binding!!
    private lateinit var rvAdapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireActivity(), 3)

        // pass it to rvLists layoutManager
        binding.ryImage.setLayoutManager(layoutManager)

        // initialize the adapter,
        // and pass the required argument
        rvAdapter = ImageAdapter(listOf())

        // attach adapter to the recycler view
        binding.ryImage.adapter = rvAdapter
        observeData()
    }

    private fun observeData() {
        mainActivityViewModel.getWeatherUpdates()
        mainActivityViewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> {
                }

                is UiState.Loading -> {
                }

                is UiState.Success -> {
                   rvAdapter.setData(it.imageList)
                }

                null -> {
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
