package com.mad.instagraph.ui.view.base

import androidx.fragment.app.Fragment
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource

abstract class BaseFragment : Fragment() {

    inline fun <T> Resource<T>.onSuccess(crossinline onSuccess: (T) -> Unit) = apply {
        successUpdates().observe(viewLifecycleOwner, { onSuccess(it) })
    }

    inline fun <T> Resource<T>.onFailure(crossinline onFailure: (Throwable) -> Unit) = apply {
        failureUpdates().observe(viewLifecycleOwner, { onFailure(it) })
    }

    inline fun <T> Resource<T>.onLoading(crossinline onLoading: (LoadingState) -> Unit) = apply {
        loadingUpdates().observe(viewLifecycleOwner, { onLoading(it) })
    }

}