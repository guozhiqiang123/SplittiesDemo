package com.gzq.splittiesdemo.common

import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.Px
import splitties.dimensions.dp
import splitties.init.appCtx
import splitties.resources.appColor

/**
 *date：2021/9/6 下午10:14
 *coder：gzq
 *email：774550196@qq.com
 *description:动态实现shape，selector。
 */

fun shape(
    @ColorInt solidColor: Int = appColor(android.R.color.transparent),
    shape: Int = GradientDrawable.RECTANGLE,
    @Px radius: Float = 0F,
    @Px topStart: Float = 0F,
    @Px topEnd: Float = 0F,
    @Px bottomEnd: Float = 0F,
    @Px bottomStart: Float = 0F,
    @ColorInt strokeColor: Int = appColor(android.R.color.transparent),
    @Px strokeWidth: Int = 1,
    @Px dashWidth: Float = 0F,
    @Px dashGap: Float = 0F,
): GradientDrawable = GradientDrawable().apply {
    setColor(solidColor)
    setShape(shape)
    cornerRadius = radius
    if (topStart + topEnd + bottomEnd + bottomStart != 0F) {
        val radiusArray = FloatArray(8)
        radiusArray[0] = topStart
        radiusArray[1] = topStart
        radiusArray[2] = topEnd
        radiusArray[3] = topEnd
        radiusArray[4] = bottomEnd
        radiusArray[5] = bottomEnd
        radiusArray[6] = bottomStart
        radiusArray[7] = bottomStart
        cornerRadii = radiusArray
    }
    setStroke(strokeWidth, strokeColor, dashWidth, dashGap)
}

//TODO:实现多状态的shape
fun shapeSL() {

}

//TODO:使用StateListDrawable实现selector
fun selector() {

}