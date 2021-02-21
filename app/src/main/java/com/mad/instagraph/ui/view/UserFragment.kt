package com.mad.instagraph.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mad.instagraph.databinding.FragmentUserBinding
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.utils.validateAndLoad
import com.mad.instagraph.ui.view.base.BaseFragment
import com.mad.instagraph.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.resource
            .onSuccess { model ->
                binding.photoImage.validateAndLoad(model.photo.url)
                binding.nameTextField.editText?.setText(model.user.getName())
            }.onFailure {
                Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
            }.onLoading {
                if (it == LoadingState.SHOW)
                    Toast.makeText(activity, "Loading ...", Toast.LENGTH_SHORT).show()
            }

    }

}