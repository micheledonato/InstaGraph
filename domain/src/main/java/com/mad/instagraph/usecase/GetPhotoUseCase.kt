package com.mad.instagraph.usecase

import com.mad.instagraph.entity.PhotoEntity
import com.mad.instagraph.repository.PhotoRepository
import com.mad.instagraph.usecase.base.BaseUseCase

class GetPhotoUseCase(
    private val photoRepository: PhotoRepository
) : BaseUseCase<PhotoEntity>() {

    override suspend fun block(): PhotoEntity {
        return photoRepository.getPhoto()
    }

}