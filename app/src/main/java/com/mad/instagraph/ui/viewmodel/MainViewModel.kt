package com.mad.instagraph.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.ui.viewmodel.base.BaseViewModel
import com.mad.instagraph.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    //private val getUserUseCase: GetUserUseCase
) : BaseViewModel() {

    val resource = Resource<UserEntity>()

    init {
        loadData()
    }

    private fun loadData() {

//        getUserUseCase.execute()
//
//
//        getUserUseCase.launch(resource)


        viewModelScope.launch(Dispatchers.IO) {
            try {
                resource.postLoading(LoadingState.SHOW)
                val response = getUser()
                if (response.id != 0L) {
                    resource.postData(response)
                } else {
                    resource.postError(Exception("id has zero"))
                }
            } catch (e: Exception) {
                resource.postError(e)
            } finally {
                resource.postLoading(LoadingState.HIDE)
            }
        }
    }

    private suspend fun getUser(): UserEntity {
        return UserEntity(id = 13, firstName = "Michele", lastName = "Donato")
    }

}