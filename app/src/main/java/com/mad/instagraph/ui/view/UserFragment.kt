package com.mad.instagraph.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mad.instagraph.R
import com.mad.instagraph.ui.utils.validateAndLoad
import com.mad.instagraph.ui.view.base.BaseFragment
import com.mad.instagraph.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment(R.layout.fragment_user) {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.photo
            .onSuccess { photo ->
                photoImage.validateAndLoad(photo.url)
            }.onFailure {
                Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
            }.onLoading {
                activity?.loader?.visibility = it.visibility
            }

        mainViewModel.user
            .onSuccess { user ->
                nameTextField.editText?.setText(user.getName())
            }.onFailure {
                Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
            }.onLoading {
                activity?.loader?.visibility = it.visibility
            }
    }

}