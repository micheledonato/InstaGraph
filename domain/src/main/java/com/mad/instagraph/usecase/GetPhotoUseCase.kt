package com.mad.instagraph.usecase

import com.mad.instagraph.entity.PhotoEntity
import com.mad.instagraph.repository.PhotoRepository
import com.mad.instagraph.usecase.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPhotoUseCase(
    private val photoRepository: PhotoRepository
) : BaseUseCase<PhotoEntity>() {

    override fun execute(): Flow<PhotoEntity> =
        flow { emit(photoRepository.getPhoto()) }

}