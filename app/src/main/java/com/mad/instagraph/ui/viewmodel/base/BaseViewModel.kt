package com.mad.instagraph.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.usecase.base.BaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun <T> BaseUseCase<T>.launch(resource: Resource<T>) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                resource.postLoading(LoadingState.SHOW)
                val response = execute()
                resource.postData(response)
            } catch (e: Exception) {
                resource.postError(e)
            } finally {
                resource.postLoading(LoadingState.HIDE)
            }
        }
    }

}