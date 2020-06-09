package com.mad.instagraph.usecase.base

import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<T> {

    abstract fun execute(): Flow<T>

}