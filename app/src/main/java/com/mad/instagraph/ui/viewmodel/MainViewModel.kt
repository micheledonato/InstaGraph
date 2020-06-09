package com.mad.instagraph.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.mad.instagraph.entity.PhotoEntity
import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.ui.model.LoadingState
import com.mad.instagraph.ui.model.Resource
import com.mad.instagraph.ui.viewmodel.base.BaseViewModel
import com.mad.instagraph.usecase.GetPhotoUseCase
import com.mad.instagraph.usecase.GetUserUseCase
import kotlinx.coroutines.flow.*

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val getPhotoUseCase: GetPhotoUseCase
) : BaseViewModel() {

    data class Model(
        val user: UserEntity,
        val photo: PhotoEntity
    )

    val resource = Resource<Model>()

    init {
        loadData()
    }

    private fun loadData() {

        /**
         * Pro: chiamate asincrone slegate tra di loro, grazie al combine.
         * Pro: Posso concatenare i dati delle due chiamate in un unico modello o posso fare delle elaborazioni prima della visualizzazione
         * Pro: Il loader finisce quando tutte e due le chiamate hanno finito.
         */

        combine(
            getUserUseCase.execute(),
            getPhotoUseCase.execute()
        ) { user, photo ->
            println("Data loaded")
            resource.postData(Model(user, photo))
        }.onStart {
            println("Start loading")
            resource.postLoading(LoadingState.SHOW)
        }.onCompletion {
            println("Loading complete")
            resource.postLoading(LoadingState.HIDE)
        }.catch { e ->
            resource.postError(e)
        }.launchIn(viewModelScope)

    }

}