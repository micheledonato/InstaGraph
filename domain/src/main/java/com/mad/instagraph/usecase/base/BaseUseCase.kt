package com.mad.instagraph.usecase.base

import kotlinx.coroutines.*

// Dispatchers.IO is designed to run tasks which need to perform Input/Output operations.
// Those operations typically require “long” waiting times.

abstract class BaseUseCase<Input, Output> {

    abstract suspend fun block(params: Input): Output

    suspend fun execute(params: Input): Output =
        withContext(Dispatchers.IO) { block(params) }

    fun executeAsync(scope: CoroutineScope, params: Input): Deferred<Output> =
        scope.async { withContext(Dispatchers.IO) { block(params) } }

}

abstract class BaseUseCaseNoInput<Output> {

    abstract suspend fun block(): Output

    suspend fun execute(): Output =
        withContext(Dispatchers.IO) { block() }

    fun executeAsync(scope: CoroutineScope): Deferred<Output> =
        scope.async { withContext(Dispatchers.IO) { block() } }

}

abstract class BaseFlowUseCase<Input, Output> {

    abstract fun block(params: Input): Output

    fun execute(params: Input): Output = block(params)

}