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
annotation
class DrawableShape

data class shape(
    @ColorInt val solidColor: Int = Color.TRANSPARENT,
    @ColorRes val solidColorRes: Int = android.R.color.transparent,
    @Px val radius: Float = 0F,
    @IntRange(from = 0x00, to = 0xFF) val alphaValue: Int = 0xFF,
    @DrawableShape val shapeValue: Int = GradientDrawable.RECTANGLE,
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
    @ColorInt normal: Int = Color.BLACK,
    @ColorInt pressed: Int = normal,
    @ColorInt selected: Int = normal,
    @ColorInt focused: Int = normal,
    @ColorInt unable: Int = normal,
): ColorStateList {
    val stateArray = Array(5) { intArrayOf() }
    //pressed
    stateArray[0] = intArrayOf(android.R.attr.state_pressed)
    //selected
    stateArray[1] = intArrayOf(android.R.attr.state_selected)
    //focused
    stateArray[2] = intArrayOf(android.R.attr.state_focused)
    //unable
    stateArray[3] = intArrayOf(-android.R.attr.state_enabled)
    //default
    stateArray[4] = intArrayOf()
    return ColorStateList(
        stateArray,
        intArrayOf(pressed, selected, focused, unable, normal)
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