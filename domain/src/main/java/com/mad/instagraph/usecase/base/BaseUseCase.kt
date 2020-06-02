package com.mad.instagraph.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCase<T> {

    protected abstract suspend fun block(): T

    fun execute(scope: CoroutineScope, onResponse: (T) -> Unit = {}) {
        scope.launch {
            val deferred = async { block() }
            onResponse(deferred.await())
        }
    }

}