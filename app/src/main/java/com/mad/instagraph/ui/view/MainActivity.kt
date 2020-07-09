package com.mad.instagraph.ui.view

import android.os.Bundle
import com.mad.instagraph.R
import com.mad.instagraph.ui.utils.loadFragment
import com.mad.instagraph.ui.view.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(UserFragment(), R.id.fragment_container)
    }

}