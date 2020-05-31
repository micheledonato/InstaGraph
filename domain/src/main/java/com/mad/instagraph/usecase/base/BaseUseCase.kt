package com.mad.instagraph.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseUseCase<T> {

    abstract suspend fun execute(): T

//    suspend fun execute(scope: CoroutineScope, dispatcher: CoroutineDispatcher= Dispatchers.IO, callback: (T) -> Unit = {}) {
//        scope.launch(dispatcher) {
//            callback()
//        }
//    }

}