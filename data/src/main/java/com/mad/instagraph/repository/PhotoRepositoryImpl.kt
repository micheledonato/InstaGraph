package com.mad.instagraph.repository

import com.mad.instagraph.entity.PhotoEntity
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay

class PhotoRepositoryImpl : PhotoRepository {

    override suspend fun getPhoto(userId: Long): PhotoEntity {
        delay(10_000L)
        return PhotoEntity(id = 310013, url = "https://www.fillmurray.com/300/300")
    }

}