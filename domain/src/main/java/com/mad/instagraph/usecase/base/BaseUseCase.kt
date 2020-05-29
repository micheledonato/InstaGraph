package com.mad.instagraph.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseUseCase {

    abstract fun run()

//    fun execute(scope: CoroutineScope, callback: (T) -> Unit = {}) {
//        scope.launch {
//            callback()
//        }
//    }



    abstract fun getResponse()

}