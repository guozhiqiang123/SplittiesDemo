package com.gzq.splittiesdemo.home.horizontal

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.ImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shape
import com.gzq.splittiesdemo.common.shapeImageView
import com.gzq.splittiesdemo.data.Tweet
import splitties.dimensions.dp
import splitties.views.dsl.core.*
import splitties.views.gravityCenter

/**
 *date：2021/9/11 上午11:09
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

sealed class HorizontalListAvatarItemUi(override val ctx: Context) : Ui {
    protected val auth = textView(theme = R.style.tv_normal_12sp_grey)
}

/**
 * 纯色描边头像
 */
class AvatarItemUiSolid(val context: Context) : HorizontalListAvatarItemUi(context) {
    private val avatar = shapeImageView {
        setStrokeColorResource(R.color.green_500)
        //超过4dp则必须设置padding，否则画笔一半绘制在边框之外
        //经常玩自定义的同学应该懂
        strokeWidth = dp(4f)
        setContentPadding(dp(2), dp(2), dp(2), dp(2))
        scaleType = ImageView.ScaleType.CENTER_CROP
        //菱形：CutCornerTreatment()；圆角：RoundedCornerTreatment()；
        shapeAppearanceModel =
            ShapeAppearanceModel.builder()
                .setAllCornerSizes(ShapeAppearanceModel.PILL)
                .build()
    }
    override val root: View
        get() = verticalLayout {
            gravity = gravityCenter
            add(avatar, lParams(width = dp(60), height = dp(60)))
            add(auth, lParams { })
        }

    fun renderUi(data: Tweet) {
        avatar.setImageResource(data.authorImageId)
        auth.text = data.author
    }
}

/**
 * 渐变色描边头像
 */
class AvatarItemUiGradient(val context: Context) : HorizontalListAvatarItemUi(context) {
    private val avatar = shapeImageView {
        scaleType = ImageView.ScaleType.CENTER_CROP
        //菱形：CutCornerTreatment()；圆角：RoundedCornerTreatment()；
        shapeAppearanceModel =
            ShapeAppearanceModel.builder()
                .setAllCornerSizes(ShapeAppearanceModel.PILL)
                .build()
    }

    override val root: View
        get() = verticalLayout {
            gravity = gravityCenter
            add(verticalLayout {
                gravity = gravityCenter
                background = shape(
                    shapeValue = GradientDrawable.OVAL, gradientColors = intArrayOf(
                        Color.parseColor("#FF5851DB"),
                        Color.parseColor("#FF833AB4"),
                        Color.parseColor("#FFF56040"),
                        Color.parseColor("#FFFCAF45")
                    ),
                    gradientType = GradientDrawable.LINEAR_GRADIENT,
                    gradientOffset = floatArrayOf(0f, 0f, 100f, 100f)
                )
                add(avatar, lParams(width = dp(52), height = dp(52)) { })
            }, lParams(width = dp(60), height = dp(60)))
            add(auth, lParams())
        }

    fun renderUi(data: Tweet) {
        avatar.setImageResource(data.authorImageId)
        auth.text = data.author
    }
}