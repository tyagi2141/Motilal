package com.example.motilal.ui.fragments.detailview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.motilal.databinding.FragmentSecondBinding
import com.example.motilal.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class DetailFragment : DaggerFragment() {

    val args: DetailFragmentArgs by navArgs()


    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: DetailViewModel

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, providerFactory).get(DetailViewModel::class.java)

        Glide.with(requireContext()).load(args.dasboardResult.avatar).into(binding.imageId)

        binding.tvAuthor.text = "Author : ${args.dasboardResult.author}"
        binding.tvName.text ="Name : ${args.dasboardResult.name}"
        binding.tvDescription.text = "Description : ${args.dasboardResult.description}"
        binding.tvGithubLink.text ="Git Link : ${args.dasboardResult.builtBy.map { it.href }.first()}"
        binding.tvGitHubUsername.text = "UserName : ${args.dasboardResult.builtBy.map { it.username }.first()}"


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}