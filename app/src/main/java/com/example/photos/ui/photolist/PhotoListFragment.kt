package com.example.photos.ui.photolist

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.photos.R
import com.example.photos.databinding.LayoutErrorBinding
import com.example.photos.databinding.PhotoListFragmentBinding
import com.example.photos.ui.UiState
import com.example.photos.ui.photolist.adapter.PhotoListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoListFragment : Fragment(R.layout.photo_list_fragment) {

    private val binding by viewBinding(PhotoListFragmentBinding::bind)
    private val errorLayoutBinding by viewBinding(LayoutErrorBinding::bind)

    private val viewModel: PhotoListViewModel by viewModel()

    private val adapter = PhotoListAdapter { clickedPhoto ->
        findNavController().navigate(
            PhotoListFragmentDirections.actionNavigateToPhotoDetails(clickedPhoto.id)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        addObservers()
        setListeners()

        viewModel.fetchPhotos()
    }


    private fun initRecyclerView() {
        binding.photosRecyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
        binding.photosRecyclerView.setHasFixedSize(true)
        binding.photosRecyclerView.adapter = adapter
    }

    private fun addObservers() {
        viewModel.uiState.observe(viewLifecycleOwner, { uiState ->
            binding.progressIndicator.isVisible = uiState is UiState.Loading

            errorLayoutBinding.retryButton.isVisible = uiState is UiState.Failure
            errorLayoutBinding.errorTextView.isVisible = uiState is UiState.Failure

            when (uiState) {
                is UiState.Success -> adapter.submitList(uiState.data)
                is UiState.Failure -> errorLayoutBinding.errorTextView.text = uiState.error.message
                else -> {
                }
            }
        })
    }

    private fun setListeners() {
        errorLayoutBinding.retryButton.setOnClickListener {
            viewModel.fetchPhotos()
        }
    }
}