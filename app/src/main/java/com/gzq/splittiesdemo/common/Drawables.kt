package com.gzq.splittiesdemo.common

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.GradientDrawable.RECTANGLE
import android.graphics.drawable.InsetDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import androidx.annotation.*
import androidx.annotation.IntRange
import com.gzq.splittiesdemo.ext.PaddingGradientDrawable
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

/**
 * 替代<shape></shape>
 * 该方法兼容了padding和margin的设置
 *
 */
fun shape(
    @ColorInt solidColor: Int = Color.TRANSPARENT,
    @ColorRes solidColorRes: Int = android.R.color.transparent,
    @Px radius: Float = 0F,
    @IntRange(from = 0x00, to = 0xFF) alphaValue: Int = 0xFF,
    @DrawableShape shapeValue: Int = RECTANGLE,
    @Px topStart: Float = 0F,
    @Px topEnd: Float = 0F,
    @Px bottomEnd: Float = 0F,
    @Px bottomStart: Float = 0F,
    @ColorInt strokeColor: Int = Color.TRANSPARENT,
    @ColorRes strokeColorRes: Int = android.R.color.transparent,
    @Px strokeWidth: Int = 0,
    @Px dashWidth: Float = 0F,
    @Px dashGap: Float = 0F,
    @Px padding: Int = 0,
    @Px paddingStart: Int = 0,
    @Px paddingEnd: Int = 0,
    @Px paddingTop: Int = 0,
    @Px paddingBottom: Int = 0,
    @Px margin: Int = 0,
    @Px marginStart: Int = 0,
    @Px marginEnd: Int = 0,
    @Px marginTop: Int = 0,
    @Px marginBottom: Int = 0,
    @Px sizeWidth: Int = 0,
    @Px sizeHeight: Int = 0,
    gradientOrientation: GradientDrawable.Orientation = GradientDrawable.Orientation.TOP_BOTTOM,
    @ColorInt gradientColors: IntArray? = null,
    gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
    gradientOffset: FloatArray? = null
): Drawable {
    val drawable = PaddingGradientDrawable().apply {
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
        setPadding(
            padding or paddingStart,
            padding or paddingTop,
            padding or paddingEnd,
            padding or paddingBottom
        )
        setSize(sizeWidth, sizeHeight)
        orientation = gradientOrientation
        setGradientType(gradientType)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            setColors(gradientColors, gradientOffset)
        } else {
            colors = gradientColors
        }
    }
    if (margin and marginStart and marginEnd and marginTop and marginBottom == 0) {
        return InsetDrawable(
            drawable,
            margin or marginStart,
            margin or marginTop,
            margin or marginEnd,
            margin or marginBottom
        )
    }
    return drawable
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