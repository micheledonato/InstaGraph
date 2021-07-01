package com.mad.instagraph.datasource

import com.mad.instagraph.entity.UserEntity

interface UserDataSource {

    suspend fun getUser(): UserEntity

}