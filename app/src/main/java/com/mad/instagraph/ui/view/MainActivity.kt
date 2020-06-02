package com.mad.instagraph.ui.view

import android.os.Bundle
import android.widget.Toast
import com.mad.instagraph.R
import com.mad.instagraph.ui.utils.validateAndLoad
import com.mad.instagraph.ui.view.base.BaseActivity
import com.mad.instagraph.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.resource.observe(
            loader,
            { model ->
                user_tv.text = model.user.getName()
                photo_iv.validateAndLoad(model.photo.url)
            },
            { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }
        )
    }

}