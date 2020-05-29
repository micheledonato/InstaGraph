package com.mad.instagraph.ui.model

import androidx.lifecycle.MutableLiveData

class Resource<T>(
    private val data: MutableLiveData<T> = MutableLiveData(),
    private val error: MutableLiveData<Throwable> = MutableLiveData(),
    private val loading: MutableLiveData<LoadingState> = MutableLiveData()
) {

    fun successUpdates() = data
    fun failureUpdates() = error
    fun loadingUpdates() = loading

    fun postData(d: T) = data.postValue(d)
    fun postError(e: Throwable) = error.postValue(e)
    fun postLoading(l: LoadingState) = loading.postValue(l)

    fun getData(): T? = data.value

}