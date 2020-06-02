package com.mad.instagraph.repository

import com.mad.instagraph.entity.PhotoEntity
import kotlinx.coroutines.delay

class PhotoRepositoryImpl : PhotoRepository {

    override suspend fun getPhoto(): PhotoEntity {
        delay(10_000L)
        return PhotoEntity(id = 310013, url = "https://i.picsum.photos/id/237/536/354.jpg")
    }

}