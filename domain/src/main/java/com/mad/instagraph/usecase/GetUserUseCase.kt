package com.mad.instagraph.usecase

import com.mad.instagraph.entity.UserEntity
import com.mad.instagraph.repository.UserRepository
import com.mad.instagraph.usecase.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<UserEntity>() {

    override fun execute(): Flow<UserEntity> =
        flow { emit(userRepository.getUser()) }

}