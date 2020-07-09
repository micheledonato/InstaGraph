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

    data class ModelResource(
        val user: UserEntity,
        val photo: PhotoEntity
    )

    val resource = Resource<ModelResource>()

    val photo = Resource<PhotoEntity>()
    val user = Resource<UserEntity>()

    init {
        loadData()
    }

    private fun loadData() {

        /**
         * Pro: Posso concatenare i dati delle due chiamate in un unico modello o posso fare delle elaborazioni prima della visualizzazione
         * Contro: le chiamate non sono più slegate ma la seconda deve aspettare che la prima finisca
         *
         * Pro: Se la seconda chiamata ha bisogno di un parametro per essere eseguita e questo paramentro gli arriva dalla prima chiamata, questa soluzione ha senso.
         */
        // Concatenate launch
        launchDataLoad(resource) {
            println("Launch started")
            val photo = getPhotoUseCase.execute()
            println("Photo ${photo.id} loaded")

            val user = getUserUseCase.execute()
            println("User ${user.id} loaded")

            ModelResource(
                user = user,
                photo = photo
            )
        }


        /**
         * Pro: chiamate asincrone slegate tra di loro, così che quando una chiamata termina mostra subito il dato e non deve aspettare l'altra chiamata.
         * Contro: la prima chiamata nasconde il loader mentre la seconda chiamata sta ancora in esecuzione.
         * Contro: Non si possono concatenare i dati delle due chiamate in un unico modello o per un elaborazione prima della visualizzazione.
         */
        // Single launch alternative version
//        launchDataLoad(user) { getUserUseCase.execute() }
//        launchDataLoad(photo) { getPhotoUseCase.execute() }

    }


}