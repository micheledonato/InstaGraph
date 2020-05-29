package com.mad.instagraph.ui.view.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource

abstract class BaseActivity : AppCompatActivity() {

    inline fun <T> Resource<T>.onSuccess(crossinline onSuccess: (T) -> Unit) = apply {
        successUpdates().observe(this@BaseActivity, Observer { onSuccess(it) })
    }

    inline fun <T> Resource<T>.onFailure(crossinline onFailure: (Throwable) -> Unit) = apply {
        failureUpdates().observe(this@BaseActivity, Observer { onFailure(it) })
    }

    inline fun <T> Resource<T>.onLoading(crossinline onLoading: (LoadingState) -> Unit) = apply {
        loadingUpdates().observe(this@BaseActivity, Observer { onLoading(it) })
    }

}