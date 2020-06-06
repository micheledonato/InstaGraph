package com.mad.instagraph.ui.view

import android.os.Bundle
import com.mad.instagraph.R
import com.mad.instagraph.ui.utils.loadFragment
import com.mad.instagraph.ui.view.base.BaseActivity
import com.mad.instagraph.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(UserFragment(), R.id.fragment_container)
    }

}