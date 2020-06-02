package com.mad.instagraph.ui.view.base

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.mad.instagraph.ui.model.Resource

abstract class BaseActivity : AppCompatActivity() {

    inline fun <T : Any> LiveData<Resource<T>>.observe(
        loader: ProgressBar,
        crossinline onSuccess: (T) -> Unit,
        crossinline onFailure: (Throwable) -> Unit
    ) {
        observe(this@BaseActivity, Observer { resource ->
            when (resource) {
                is Resource.Success -> {
                    loader.visibility = INVISIBLE
                    onSuccess(resource.data)
                }
                is Resource.Error -> {
                    loader.visibility = INVISIBLE
                    onFailure(resource.error)
                }
                is Resource.InProgress -> loader.visibility = VISIBLE
            }
        })
    }

}