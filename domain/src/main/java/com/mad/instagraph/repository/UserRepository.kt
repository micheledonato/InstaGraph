package com.mad.instagraph.repository

import com.mad.instagraph.entity.UserEntity

interface UserRepository {

    suspend fun getUser(): UserEntity

}