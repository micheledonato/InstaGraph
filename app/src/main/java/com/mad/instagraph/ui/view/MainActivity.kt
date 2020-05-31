package com.mad.instagraph.ui.view

import android.os.Bundle
import android.widget.Toast
import coil.api.load
import com.mad.instagraph.R
import com.mad.instagraph.ui.view.base.BaseActivity
import com.mad.instagraph.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.photo
            .onSuccess { photo ->
                photo_iv.load(photo.url)
            }.onFailure {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }.onLoading {
                loader.visibility = it.visibility
            }

        mainViewModel.user
            .onSuccess { user ->
                user_tv.text = user.getName()
            }.onFailure {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }.onLoading {
                loader.visibility = it.visibility
            }

        //loadFragment(UserFragment(), R.id.fragment_container)
    }

}