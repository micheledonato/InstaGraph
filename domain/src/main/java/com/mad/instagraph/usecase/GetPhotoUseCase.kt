package com.mad.instagraph.usecase

import com.mad.instagraph.entity.PhotoEntity
import com.mad.instagraph.repository.PhotoRepository
import com.mad.instagraph.usecase.base.BaseUseCase

class GetPhotoUseCase(
    private val photoRepository: PhotoRepository
) : BaseUseCase<GetPhotoUseCase.Params, PhotoEntity>() {


    override suspend fun block(params: Params): PhotoEntity =
        photoRepository.getPhoto(params.userId)


    data class Params(val userId: Long)


}