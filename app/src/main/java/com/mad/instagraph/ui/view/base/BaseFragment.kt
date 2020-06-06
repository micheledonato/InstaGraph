package com.mad.instagraph.ui.view.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    inline fun <T> Resource<T>.onSuccess(crossinline onSuccess: (T) -> Unit) = apply {
        successUpdates().observe(viewLifecycleOwner, Observer { onSuccess(it) })
    }

    inline fun <T> Resource<T>.onFailure(crossinline onFailure: (Throwable) -> Unit) = apply {
        failureUpdates().observe(viewLifecycleOwner, Observer { onFailure(it) })
    }

    inline fun <T> Resource<T>.onLoading(crossinline onLoading: (LoadingState) -> Unit) = apply {
        loadingUpdates().observe(viewLifecycleOwner, Observer { onLoading(it) })
    }

}