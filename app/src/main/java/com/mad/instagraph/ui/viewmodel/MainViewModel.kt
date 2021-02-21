package com.mad.instagraph.ui.viewmodel

import com.mad.instagraph.entity.PhotoEntity
import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.ui.viewmodel.base.BaseViewModel
import com.mad.instagraph.usecase.GetPhotoUseCase
import com.mad.instagraph.usecase.GetStatusUseCase
import com.mad.instagraph.usecase.GetUserDetailsUseCase
import com.mad.instagraph.usecase.GetUserUseCase
import kotlinx.coroutines.flow.*

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getPhotoUseCase: GetPhotoUseCase,
    private val getStatusUseCase: GetStatusUseCase,
    private val getUserDetailsUseCase: GetUserDetailsUseCase
) : BaseViewModel() {

    data class ModelResource(
        val user: UserEntity,
        val photo: PhotoEntity,
        val isActive: Boolean
    )

    val resource = Resource<ModelResource>()


    init {
//        loadData()
        loadFlowData()
    }


    private fun loadData() {

        launchDataLoad(resource) { scope ->

//            var result: ModelResource? = null
//            val time = measureTimeMillis {

            println("Launch started")

            val user = getUserUseCase.execute()
            println("User ${user.id} loaded")

            val (photo, status) = blend(
                getPhotoUseCase.executeAsync(scope, GetPhotoUseCase.Params(user.id)),
                getStatusUseCase.executeAsync(scope, GetStatusUseCase.Params(user.id))
            ) { photo, status ->

                println("Photo ${photo.id} loaded")
                println("Status ${status.id} loaded")

                Pair(photo, status)
            }

            ModelResource(
                user = user,
                photo = photo,
                isActive = status.isActive
            )

//            }
//            println("Time = $time")
//            return@launchDataLoad result!!

        }

    }

    private fun loadFlowData() {

        launchFlowDataLoad(resource) {

            val user = getUserUseCase.execute()
            val photo = getPhotoUseCase.execute(GetPhotoUseCase.Params(user.id))

            ModelResource(
                user = user,
                photo = photo,
                isActive = false
            )

        }

    }

    private fun loadCombine(){



    }

}