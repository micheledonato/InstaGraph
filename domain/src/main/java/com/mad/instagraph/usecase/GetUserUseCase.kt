package com.mad.instagraph.usecase

import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.repository.UserRepository
import com.mad.instagraph.usecase.base.BaseUseCase

class GetUserUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<UserEntity>() {

    override suspend fun execute(): UserEntity {
        return userRepository.getUser()
    }

}