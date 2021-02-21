package com.mad.instagraph.repository

import com.mad.instagraph.entity.UserDetailsEntity
import com.mad.instagraph.entity.UserEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl : UserRepository {

    override suspend fun getUser(): UserEntity {
        delay(5_000L)
        return UserEntity(id = 13, firstName = "Bill", lastName = "Murray")
    }

    override fun userDetails(): Flow<UserDetailsEntity> = flow {
        delay(3_000L)
        // call a suspend function of API and return details
        val details = UserDetailsEntity(height = 1.90F, weight = 77.7f, age = 34)
        emit(details)
    }

}