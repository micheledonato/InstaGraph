package com.mad.instagraph.ui.view

import android.os.Bundle
import android.util.Log
import com.mad.instagraph.R
import com.mad.instagraph.databinding.ActivityMainBinding
import com.mad.instagraph.ui.utils.loadFragment
import com.mad.instagraph.ui.view.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            loadFragment(UserFragment(), R.id.fragment_container)
            Log.d("MainActivity", "Fragment is null")
        } else {
            Log.d("MainActivity", "Fragment is not null")
        }
    }

}