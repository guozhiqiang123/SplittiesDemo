package com.gzq.splittiesdemo.home.horizontal

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shapeImageView
import com.gzq.splittiesdemo.data.Tweet
import splitties.dimensions.dp
import splitties.resources.color
import splitties.views.backgroundColor
import splitties.views.dsl.core.Ui
import splitties.views.padding

/**
 *company：成都环宇知了科技有限公司
 *date：2021/9/11 上午11:09
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

class HorizontalListAvatarItemUi(override val ctx: Context) : Ui {
    private val avatar = shapeImageView {
        setStrokeColorResource(R.color.green_500)
        strokeWidth=dp(8f)
        scaleType = ImageView.ScaleType.CENTER_CROP
        shapeAppearanceModel =
            ShapeAppearanceModel.builder().setAllCornerSizes(ShapeAppearanceModel.PILL)
                .build()
    }
    override val root: View
        get() {
            return avatar
        }

    fun renderUi(data: Tweet) {
        avatar.setImageResource(data.authorImageId)
    }
}