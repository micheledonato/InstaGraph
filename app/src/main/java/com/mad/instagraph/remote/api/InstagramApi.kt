package com.mad.instagraph.remote.api

import com.mad.instagraph.entity.UserEntity
import retrofit2.http.GET

interface InstagramApi {

    @GET()
    suspend fun getUser(): UserEntity

}