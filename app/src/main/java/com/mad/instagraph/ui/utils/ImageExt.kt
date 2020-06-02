package com.mad.instagraph.ui.utils

import android.webkit.URLUtil
import android.widget.ImageView
import coil.api.load
import coil.transform.RoundedCornersTransformation

fun ImageView.validateAndLoad(url: String) {
    try {
        require(URLUtil.isValidUrl(url)) { "The url = $url is not valid" }
        load(url) {
            crossfade(2_000)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}