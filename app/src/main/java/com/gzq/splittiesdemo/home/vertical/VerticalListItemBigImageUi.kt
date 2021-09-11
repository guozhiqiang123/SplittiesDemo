package com.gzq.splittiesdemo.home.vertical

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shapeImageView
import com.gzq.splittiesdemo.data.Item
import splitties.dimensions.dp
import splitties.views.dsl.core.*
import splitties.views.padding
import splitties.views.selectable.SelectableLinearLayout

/**
 * VerticalList-大图模式
 */
class VerticalListItemBigImageUi(override val ctx: Context) : Ui {
    private val corner4Image = shapeImageView(allCorner = 4) {
        scaleType = ImageView.ScaleType.CENTER_CROP
    }

    //中粗，也可以使用mediumTextView{}来布局
    private val title = textView(theme = R.style.tv_medium_20sp_black)

    private val subTitle = textView(theme = R.style.tv_normal_14sp_black)

    private val source = textView(theme = R.style.tv_medium_14sp_grey)

    override val root: View
        get() = SelectableLinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            padding = dp(16)
            //图片
            add(corner4Image, lParams(width = matchParent, height = dp(150)))
            //间隙
            add(space(), lParams(width = matchParent, height = dp(16)))
            //主标题
            add(title, lParams(width = matchParent))
            //副标题
            add(subTitle, lParams(width = matchParent))
            //来源
            add(source, lParams())
        }

    fun renderUi(data: Item) {
        corner4Image.setImageResource(data.imageId)
        title.text = data.title
        subTitle.text = data.subtitle
        source.text = data.source
    }
}