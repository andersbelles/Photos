package com.example.photos.ui.photodetails

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.photos.R
import com.example.photos.databinding.PhotoDetailsFragmentBinding
import com.example.photos.databinding.PhotoListFragmentBinding
import com.example.photos.ui.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoDetailsFragment : Fragment(R.layout.photo_details_fragment) {

    private val args: PhotoDetailsFragmentArgs by navArgs()

    private val binding by viewBinding(PhotoDetailsFragmentBinding::bind)

    private val viewModel: PhotoDetailsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addObservers()

        viewModel.fetchPhoto(args.photoId)
    }

    private fun addObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            if (uiState is UiState.Success) {
                Glide
                    .with(requireContext())
                    .load(uiState.data.url + ".png")
                    .placeholder(R.drawable.ic_baseline_block_24)
                    .into(binding.photoImageView)
            }
        }
    }
}