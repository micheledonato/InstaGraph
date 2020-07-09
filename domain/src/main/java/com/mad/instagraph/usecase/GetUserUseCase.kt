package com.mad.instagraph.usecase

import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.repository.UserRepository
import com.mad.instagraph.usecase.base.BaseUseCaseNoInput

class GetUserUseCase(
    private val userRepository: UserRepository
) : BaseUseCaseNoInput<UserEntity>() {


    override suspend fun block(): UserEntity =
        userRepository.getUser()


}