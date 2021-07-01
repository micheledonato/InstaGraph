package com.mad.instagraph.remote.datasource

import com.mad.instagraph.datasource.UserDataSource
import com.mad.instagraph.entity.UserEntity
import kotlinx.coroutines.delay

class UserDataSourceImpl : UserDataSource {

    override suspend fun getUser(): UserEntity {
        delay(5_000L)
        return UserEntity(id = 13, firstName = "Bill", lastName = "Murray")
    }

}