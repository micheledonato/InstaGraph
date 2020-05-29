package com.mad.instagraph.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.usecase.base.BaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun BaseUseCase.execute() {
//        execute(viewModelScope)


    }


    fun <T> BaseUseCase.launch(resource: Resource<T>) {
        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                resource.postLoading(LoadingState.SHOW)
//                val response = getResponse()
//                if (response.id != 0L) {
//                    resource.postData(response)
//                } else {
//                    resource.postError(Exception("id has zero"))
//                }
//            } catch (e: Exception) {
//                resource.postError(e)
//            } finally {
//                resource.postLoading(LoadingState.HIDE)
//            }
        }
    }

}