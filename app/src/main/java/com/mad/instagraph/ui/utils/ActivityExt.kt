package com.mad.instagraph.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.loadFragment(newFragment: Fragment, container: Int, animate: Boolean = false) {
    try {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        /*
        if (animate) fragmentTransaction.setCustomAnimations(
            R.anim.slide_in_from_right, R.anim.slide_out_to_left,
            R.anim.slide_in_from_left, R.anim.slide_out_to_right
        )
        */
        fragmentTransaction.replace(container, newFragment)
        fragmentTransaction.commit()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}