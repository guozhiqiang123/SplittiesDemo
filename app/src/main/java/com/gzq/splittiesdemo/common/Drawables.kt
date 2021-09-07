package com.gzq.splittiesdemo.common

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.annotation.Px

/**
 *date：2021/9/6 下午10:14
 *coder：gzq
 *email：774550196@qq.com
 *description:动态实现shape，selector。
 */

fun shape(
    @ColorInt solidColor: Int = Color.TRANSPARENT,
    @Px radius: Float = 0F,
    @IntRange(from = 0x00, to = 0xFF) alpha: Int = 0xFF,
    shape: Int = GradientDrawable.RECTANGLE,
    @Px topStart: Float = 0F,
    @Px topEnd: Float = 0F,
    @Px bottomEnd: Float = 0F,
    @Px bottomStart: Float = 0F,
    @ColorInt strokeColor: Int = Color.TRANSPARENT,
    @Px strokeWidth: Int = 0,
    @Px dashWidth: Float = 0F,
    @Px dashGap: Float = 0F,
): GradientDrawable = GradientDrawable().apply {
    setShape(shape)
    setColor(solidColor)
    setAlpha(alpha)
    cornerRadius = radius
    if (topStart + topEnd + bottomEnd + bottomStart != 0F) {
        cornerRadii = floatArrayOf(
            topStart,
            topStart,
            topEnd,
            topEnd,
            bottomEnd,
            bottomEnd,
            bottomStart,
            bottomStart
        )
    }
    setStroke(strokeWidth, strokeColor, dashWidth, dashGap)
}

fun stateColor(
    @ColorInt normal: Int = Color.TRANSPARENT,
    @ColorInt pressed: Int = normal,
    @ColorInt focused: Int = normal,
    @ColorInt unable: Int = normal,
): ColorStateList {
    val stateArray = Array(6) { intArrayOf() }
    stateArray[0] = intArrayOf()
    stateArray[1] = intArrayOf(android.R.attr.state_pressed, android.R.attr.state_enabled)
    stateArray[2] = intArrayOf(android.R.attr.state_enabled, android.R.attr.state_focused)
    stateArray[3] = intArrayOf(android.R.attr.state_enabled)
    stateArray[4] = intArrayOf(android.R.attr.state_focused)
    stateArray[5] = intArrayOf(android.R.attr.state_window_focused)
    return ColorStateList(stateArray, intArrayOf(normal, pressed, focused, normal, focused, unable))
}

fun selector(
    normal: GradientDrawable? = null,
    pressed: GradientDrawable? = null,
    focused: GradientDrawable? = null,
    unable: GradientDrawable? = null
): StateListDrawable = StateListDrawable().apply {
    /**
    <attr name="state_focused" format="boolean" />
    <attr name="state_window_focused" format="boolean" />
    <attr name="state_enabled" format="boolean" />
    <attr name="state_checkable" format="boolean"/>
    <attr name="state_checked" format="boolean"/>
    <attr name="state_selected" format="boolean" />
    <attr name="state_pressed" format="boolean" />
    <attr name="state_activated" format="boolean" />
    <attr name="state_active" format="boolean" />
    <attr name="state_single" format="boolean" />
    <attr name="state_first" format="boolean" />
    <attr name="state_middle" format="boolean" />
    <attr name="state_last" format="boolean" />
    <attr name="state_accelerated" format="boolean" />
    <attr name="state_hovered" format="boolean" />
    <attr name="state_drag_can_accept" format="boolean" />
    <attr name="state_drag_hovered" format="boolean" />
    <attr name="state_accessibility_focused" format="boolean" />
     */
//    addState(intArrayOf(-android.R.attr.state_pressed), normal)
//    addState(intArrayOf(android.R.attr.state_pressed), pressed)
    addState(intArrayOf(-android.R.attr.state_enabled), normal)
    addState(intArrayOf(android.R.attr.state_enabled), unable)
}