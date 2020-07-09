package com.mad.instagraph.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {


    fun <T> launchDataLoad(resource: Resource<T>, block: suspend (CoroutineScope) -> T): Job {
        return viewModelScope.launch {
            try {
                resource.postLoading(LoadingState.SHOW)
                val response = block(this)
                resource.postData(response)
            } catch (e: Exception) {
                resource.postError(e)
            } finally {
                resource.postLoading(LoadingState.HIDE)
            }
        }
    }


    suspend inline fun <T1, T2, R> blend(
        deferred1: Deferred<T1>,
        deferred2: Deferred<T2>,
        crossinline transform: (T1, T2) -> R
    ): R = transform(deferred1.await(), deferred2.await())


    suspend inline fun <T1, T2, T3, R> blend(
        deferred1: Deferred<T1>,
        deferred2: Deferred<T2>,
        deferred3: Deferred<T3>,
        crossinline transform: (T1, T2, T3) -> R
    ): R = transform(deferred1.await(), deferred2.await(), deferred3.await())


}