package com.mad.instagraph.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun <T> launchDataLoad(resource: Resource<T>, block: suspend () -> T): Job {
        return viewModelScope.launch {
            try {
                println("Loading started")
                resource.postLoading(LoadingState.SHOW)
                val response = block()
                resource.postData(response)
                println("Data Loaded")
            } catch (e: Exception) {
                resource.postError(e)
            } finally {
                resource.postLoading(LoadingState.HIDE)
            }
        }
    }

}