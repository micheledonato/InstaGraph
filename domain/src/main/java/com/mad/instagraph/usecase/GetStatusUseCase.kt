package com.mad.instagraph.usecase

import com.mad.instagraph.entity.StatusEntity
import com.mad.instagraph.repository.StatusRepository
import com.mad.instagraph.usecase.base.BaseUseCase

class GetStatusUseCase(
    private val repository: StatusRepository
) : BaseUseCase<GetStatusUseCase.Params, StatusEntity>() {


    override suspend fun block(params: Params): StatusEntity =
        repository.getStatus(params.userId)


    data class Params(val userId: Long)


}