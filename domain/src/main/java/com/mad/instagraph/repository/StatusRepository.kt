package com.mad.instagraph.repository

import com.mad.instagraph.entity.StatusEntity

interface StatusRepository {

    suspend fun getStatus(userId: Long): StatusEntity

}