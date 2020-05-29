package com.mad.instagraph.ui.model

import android.view.View

sealed class LoadingState private constructor(val visibility: Int) {
    object SHOW : LoadingState(View.VISIBLE)
    object HIDE : LoadingState(View.INVISIBLE)
}