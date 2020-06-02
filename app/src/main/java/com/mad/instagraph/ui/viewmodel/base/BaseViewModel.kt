package com.mad.instagraph.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.usecase.base.BaseUseCase

abstract class BaseViewModel : ViewModel() {

    /**
     * Contro: devo spostare il postLoading fuori dal blocco di gestione della resource
     */
    fun <T> BaseUseCase<T>.launchDataLoad(resource: Resource<T>) {
        println("Loading started")
        resource.postLoading(LoadingState.SHOW)
        execute(viewModelScope) { response ->
            try {
                resource.postData(response)
                println("Data loaded")
            } catch (e: Exception) {
                resource.postError(e)
            } finally {
                resource.postLoading(LoadingState.HIDE)
            }
        }
    }

}