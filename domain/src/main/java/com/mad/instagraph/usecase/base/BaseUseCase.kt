package com.mad.instagraph.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

abstract class BaseUseCase<Input, Output> {

    abstract suspend fun block(params: Input): Output

    suspend fun execute(params: Input): Output = block(params)

    fun executeAsync(scope: CoroutineScope, params: Input): Deferred<Output> =
        scope.async { block(params) }

}

abstract class BaseUseCaseNoInput<Output> {

    abstract suspend fun block(): Output

    suspend fun execute(): Output = block()

    fun executeAsync(scope: CoroutineScope): Deferred<Output> =
        scope.async { block() }

}