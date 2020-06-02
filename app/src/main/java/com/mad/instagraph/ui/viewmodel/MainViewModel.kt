package com.mad.instagraph.ui.viewmodel

import com.mad.instagraph.entity.PhotoEntity
import com.mad.instagraph.entity.UserEntity
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

    val resource = liveDataBuilder {
        val user = getUserUseCase.execute()
        val photo = getPhotoUseCase.execute()
        Model(user, photo)
    }

}