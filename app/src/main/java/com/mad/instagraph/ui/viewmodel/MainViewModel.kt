package com.mad.instagraph.ui.viewmodel

import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.ui.viewmodel.base.BaseViewModel
import com.mad.instagraph.usecase.GetUserUseCase

class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel() {

    val resource = Resource<UserEntity>()

    init {
        loadData()
    }

    private fun loadData() {

        getUserUseCase.launch(resource)

    }

}