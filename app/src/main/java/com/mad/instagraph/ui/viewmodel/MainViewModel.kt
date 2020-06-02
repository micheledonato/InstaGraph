package com.mad.instagraph.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mad.instagraph.entity.PhotoEntity
import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.ui.viewmodel.base.BaseViewModel
import com.mad.instagraph.usecase.GetPhotoUseCase
import com.mad.instagraph.usecase.GetUserUseCase

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getPhotoUseCase: GetPhotoUseCase
) : BaseViewModel() {

    data class Model(
        val user: UserEntity,
        val photo: PhotoEntity
    )

    lateinit var resource: LiveData<Resource<Model>>

    init {
        loadData()
    }

    private fun loadData() {
        resource = liveData<Resource<Model>> {
            println("Start loading")
            emit(Resource.InProgress)
            try {
                val user = getUserUseCase.execute()
                val photo = getPhotoUseCase.execute()
                println("Data loaded")
                emit(Resource.Success(Model(user, photo)))
            } catch (e: Exception) {
                println("Error")
                emit(Resource.Error(e))
            }
        }
    }

}