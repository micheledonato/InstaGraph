package com.mad.instagraph.repository

import com.mad.instagraph.entity.StatusEntity
import kotlinx.coroutines.delay

class StatusRepositoryImpl : StatusRepository {

    override suspend fun getStatus(userId: Long): StatusEntity {
        delay(3_000)
        return StatusEntity(id = 1023, isActive = true)
    }

}