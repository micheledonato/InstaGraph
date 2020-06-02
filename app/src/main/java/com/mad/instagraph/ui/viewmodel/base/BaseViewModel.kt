package com.mad.instagraph.ui.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mad.instagraph.ui.model.Resource

abstract class BaseViewModel : ViewModel() {

    fun <T : Any> liveDataBuilder(block: suspend () -> T) = liveData<Resource<T>> {
        println("Start loading")
        emit(Resource.InProgress)
        try {
            val response = block()
            println("Data loaded")
            emit(Resource.Success(response))
        } catch (e: Exception) {
            println("Error")
            emit(Resource.Error(e))
        }
    }

}