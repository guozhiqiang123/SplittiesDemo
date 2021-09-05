package com.gzq.splittiesdemo.ext

import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.app.ComponentActivity
import androidx.core.view.doOnDetach
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import splitties.views.gravityCenter
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 *date：2021/9/4 下午5:54
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

inline fun FrameLayout.layoutGravityCenter(
    width: Int = FrameLayout.LayoutParams.WRAP_CONTENT,
    height: Int = FrameLayout.LayoutParams.WRAP_CONTENT
): FrameLayout.LayoutParams {
    var params = layoutParams as? FrameLayout.LayoutParams
    if (params == null) params = FrameLayout.LayoutParams(width, height)
    params.gravity = gravityCenter
    return params
}

inline fun <reified T> TextView.observeText(): Observer<T> {
    return Observer<T> {
        text = value(it)
    }
}

inline fun <reified T> value(t: T): String {
    return when (T::class) {
        String::class.java -> t as String
        else -> ""
    }
}