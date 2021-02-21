package com.mad.instagraph.repository

import com.mad.instagraph.entity.UserDetailsEntity
import com.mad.instagraph.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUser(): UserEntity

    fun userDetails(): Flow<UserDetailsEntity>

}