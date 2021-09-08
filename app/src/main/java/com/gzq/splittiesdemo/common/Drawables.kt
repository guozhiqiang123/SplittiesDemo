package com.gzq.splittiesdemo.common

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import androidx.annotation.*
import androidx.annotation.IntRange
import splitties.resources.appColor

/**
 *date：2021/9/6 下午10:14
 *coder：gzq
 *email：774550196@qq.com
 *description:动态实现shape，selector。
 */

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@MustBeDocumented
@IntDef(
    GradientDrawable.RECTANGLE,
    GradientDrawable.OVAL,
    GradientDrawable.LINE,
    GradientDrawable.RING
)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class DrawableShape

data class shape(
    @ColorInt val solidColor: Int = Color.TRANSPARENT,
    @ColorRes val solidColorRes: Int = android.R.color.transparent,
    @Px val radius: Float = 0F,
    @IntRange(from = 0x00, to = 0xFF) val alphaValue: Int = 0xFF,
    @DrawableShape val shapeValue: Int = RECTANGLE,
    @Px val topStart: Float = 0F,
    @Px val topEnd: Float = 0F,
    @Px val bottomEnd: Float = 0F,
    @Px val bottomStart: Float = 0F,
    @ColorInt val strokeColor: Int = Color.TRANSPARENT,
    @ColorRes val strokeColorRes: Int = android.R.color.transparent,
    @Px val strokeWidth: Int = 0,
    @Px val dashWidth: Float = 0F,
    @Px val dashGap: Float = 0F
) : GradientDrawable() {
    init {
        shape = shapeValue
        setColor(solidColor or appColor(solidColorRes))
        alpha = alphaValue
        cornerRadius = radius
        if (topStart != 0F && topEnd != 0F && bottomEnd != 0F && bottomStart != 0F) {
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
        setStroke(strokeWidth, strokeColor or appColor(strokeColorRes), dashWidth, dashGap)
    }
}

/**
 * 替代res/color/下的<selector></selector>
 */
fun stateColor(
    @ColorInt normal: Int = Color.TRANSPARENT,
    @ColorRes normalRes: Int = android.R.color.transparent,
    @ColorInt pressed: Int = normal,
    @ColorRes pressedRes: Int = normalRes,
    @ColorInt selected: Int = normal,
    @ColorRes selectedRes: Int = normalRes,
    @ColorInt checked: Int = normal,
    @ColorRes checkedRes: Int = normalRes,
    @ColorInt focused: Int = normal,
    @ColorRes focusedRes: Int = normalRes,
    @ColorInt unable: Int = normal,
    @ColorRes unableRes: Int = normalRes
): ColorStateList {
    val stateArray = Array(6) { intArrayOf() }
    //pressed
    stateArray[0] = intArrayOf(android.R.attr.state_pressed)
    //selected
    stateArray[1] = intArrayOf(android.R.attr.state_selected)
    //checked
    stateArray[2] = intArrayOf(android.R.attr.state_checked)
    //focused
    stateArray[3] = intArrayOf(android.R.attr.state_focused)
    //unable
    stateArray[4] = intArrayOf(-android.R.attr.state_enabled)
    //default
    stateArray[5] = intArrayOf()
    return ColorStateList(
        stateArray,
        intArrayOf(
            pressed or appColor(pressedRes),
            selected or appColor(selectedRes),
            checked or appColor(checkedRes),
            focused or appColor(focusedRes),
            unable or appColor(unableRes),
            normal or appColor(normalRes)
        )
    )
}

/**
 * 替代<selector></selector>
 */
fun selector(
    normal: Drawable,
    pressed: Drawable? = null,
    selected: Drawable? = null,
    unable: Drawable? = null
): StateListDrawable = StateListDrawable().apply {
    //pressed
    addState(intArrayOf(android.R.attr.state_pressed), pressed)
    //selected
    addState(intArrayOf(android.R.attr.state_selected), selected)
    //unable
    addState(intArrayOf(-android.R.attr.state_enabled, android.R.attr.state_window_focused), unable)
    //default
    addState(intArrayOf(), normal)
}