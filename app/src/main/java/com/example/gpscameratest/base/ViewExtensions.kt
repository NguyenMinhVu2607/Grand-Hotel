package com.example.gpscameratest.base

import android.view.View
import android.view.animation.AlphaAnimation

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.setOnUnDoubleClickListener(onUnDoubleClick: (View) -> Unit) {
    setOnClickListener(UnDoubleClick {
//        applyClickEffect(it)
        onUnDoubleClick(it)
    })
}

fun View.setOnClickEffectListener(onClick: (View) -> Unit) {
    setOnClickListener {
        applyClickEffect(it)
        onClick(it)
    }
}

fun applyClickEffect(view: View) {
    val animation = AlphaAnimation(1.0f, 0.5f) .apply {
        duration = 134
        repeatMode = AlphaAnimation.REVERSE
        repeatCount = 1

    }
    view.startAnimation(animation)
}