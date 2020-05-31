package com.mad.instagraph.repository

import com.mad.instagraph.entity.PhotoEntity

interface PhotoRepository {

    suspend fun getPhoto(): PhotoEntity

}