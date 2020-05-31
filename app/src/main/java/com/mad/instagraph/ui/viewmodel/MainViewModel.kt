package com.mad.instagraph.ui.viewmodel

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

    val photo = Resource<PhotoEntity>()
    val user = Resource<UserEntity>()

    init {
        loadData()
    }

    private fun loadData() {

        getPhotoUseCase.launch(photo)
        getUserUseCase.launch(user)

    }

}