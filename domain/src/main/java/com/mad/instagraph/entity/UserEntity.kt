package com.mad.instagraph.entity

data class UserEntity(
    val id: Long,
    val firstName: String,
    val lastName: String
) {

    fun getName() = "$firstName $lastName"

}

data class UserDetailsEntity(
    val height: Float,
    val weight: Float,
    val age: Int
)