package com.mad.instagraph.remote.api

import com.mad.instagraph.entity.UserEntity
import retrofit2.http.GET

interface Api {

    @GET()
    suspend fun getUser(): UserEntity

}