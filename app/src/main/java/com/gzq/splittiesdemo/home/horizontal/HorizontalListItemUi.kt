package com.gzq.splittiesdemo.home.horizontal

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shapeImageView
import com.gzq.splittiesdemo.data.Item
import splitties.dimensions.dp
import splitties.views.dsl.core.*
import splitties.views.dsl.material.materialCardView
import splitties.views.padding

/**
 *date：2021/9/10 下午10:40
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class HorizontalListItemUi(override val ctx: Context) : Ui {
    private val corner4Image = shapeImageView(topStart = 4, topEnd = 4) {
        scaleType = ImageView.ScaleType.CENTER_CROP
    }

    //中粗，也可以使用mediumTextView{}来布局
    private val title = textView(theme = R.style.tv_medium_20sp_black) {
        maxLines = 2
        ellipsize = TextUtils.TruncateAt.END
    }

    private val subTitle = textView(theme = R.style.tv_normal_14sp_black) {
        maxLines = 1
        ellipsize = TextUtils.TruncateAt.END
    }

    private val source = textView(theme = R.style.tv_medium_14sp_grey)

    override val root: View
        get() = materialCardView {
            cardElevation = dp(1F)
            add(verticalLayout {
                orientation = LinearLayout.VERTICAL

                //图片
                add(corner4Image, lParams(width = matchParent, height = dp(100)))
                add(verticalLayout {
                    padding = dp(16)
                    //主标题
                    add(title, lParams(width = matchParent))
                    //副标题
                    add(subTitle, lParams(width = matchParent))
                    //来源
                    add(source, lParams())
                }, lParams(matchParent, matchParent))
            }, lParams(matchParent, matchParent) { })
        }

    fun renderUi(data: Item) {
        corner4Image.setImageResource(data.imageId)
        title.text = data.title
        subTitle.text = data.subtitle
        source.text = data.source
    }
}