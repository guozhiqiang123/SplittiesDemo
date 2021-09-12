package com.gzq.splittiesdemo.home.grid

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shapeImageView
import com.gzq.splittiesdemo.data.Item
import splitties.dimensions.dp
import splitties.views.dsl.core.*
import splitties.views.dsl.material.materialCardView
import splitties.views.gravityCenter
import splitties.views.padding

/**
 *date：2021/9/12 下午9:03
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class GridItemImageUi(override val ctx: Context) : Ui {

    private val image = shapeImageView(topStart = 4, topEnd = 4) {
        scaleType = ImageView.ScaleType.CENTER_CROP
    }
    private val title = textView(theme = R.style.tv_medium_14sp_black) { }

    private val subTitle = textView(theme = R.style.tv_normal_14sp_black) {
        maxLines = 3
        ellipsize = TextUtils.TruncateAt.END
    }

    private val source = textView(theme = R.style.tv_medium_14sp_grey) { }

    override val root: View
        get() = materialCardView {
            cardElevation = dp(1f)
            add(verticalLayout {
                gravity = gravityCenter
                add(image, lParams(width = matchParent, height = dp(80)))
                add(verticalLayout {
                    padding = dp(8)
                    //主标题
                    add(title, lParams(width = matchParent))
                    //副标题
                    add(subTitle, lParams(width = matchParent))
                    //来源
                    add(source, lParams())
                }, lParams(matchParent, matchParent))
            }, lParams(width = matchParent, height = matchParent))
        }

    fun renderUi(data: Item) {
        image.setImageResource(data.imageId)
        title.text = data.title
        subTitle.text = data.subtitle
        source.text = data.source
    }
}