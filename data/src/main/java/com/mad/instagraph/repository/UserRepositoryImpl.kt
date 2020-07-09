package com.mad.instagraph.repository

import com.mad.instagraph.entity.UserEntity
import kotlinx.coroutines.delay

class UserRepositoryImpl : UserRepository {

    override suspend fun getUser(): UserEntity {
        delay(5_000L)
        return UserEntity(id = 13, firstName = "Bill", lastName = "Murray")
    }

}