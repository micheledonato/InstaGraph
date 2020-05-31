package com.mad.instagraph.usecase

import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.usecase.base.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GetUserUseCase : BaseUseCase<UserEntity>() {

    override suspend fun execute(): UserEntity {
        return getUser()
    }


    private suspend fun getUser(): UserEntity {
        delay(5000L)
        return UserEntity(id = 13, firstName = "Michele", lastName = "Donato")
    }

}