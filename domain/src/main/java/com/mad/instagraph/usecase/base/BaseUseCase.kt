package com.mad.instagraph.usecase.base

abstract class BaseUseCase<T> {

    abstract suspend fun execute(): T

}