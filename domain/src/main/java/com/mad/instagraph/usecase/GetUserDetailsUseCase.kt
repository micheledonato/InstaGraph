package com.mad.instagraph.usecase

import com.mad.instagraph.entity.UserDetailsEntity
import com.mad.instagraph.repository.UserRepository
import com.mad.instagraph.usecase.base.BaseFlowUseCase
import kotlinx.coroutines.flow.Flow

class GetUserDetailsUseCase(
    private val userRepository: UserRepository
) : BaseFlowUseCase<GetUserDetailsUseCase.Params, Flow<UserDetailsEntity>>() {

    data class Params(val id: Long)

    override fun block(params: Params): Flow<UserDetailsEntity> {
        return userRepository.userDetails()
    }

}