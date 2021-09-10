package com.gzq.splittiesdemo.home.vertical

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.corner4ImageView
import com.gzq.splittiesdemo.data.Item
import splitties.dimensions.dp
import splitties.resources.color
import splitties.resources.styledDrawable
import splitties.views.dsl.core.*
import splitties.views.padding

class VerticalListItemSmallImageUi(override val ctx: Context) : Ui {
    private val corner4Image = corner4ImageView() {
        scaleType = ImageView.ScaleType.CENTER_CROP
    }

    //可以直接使用style
    private val centerTitle = textView(theme = R.style.tv_normal_16sp_grey)

    //也可以动态设置
    private val centerSubTitle = textView {
        textSize = 14f
        setTextColor(color(R.color.text_grey))
    }

    private val favIcon = imageButton {
        background = styledDrawable(R.attr.selectableItemBackgroundBorderless)
        setImageResource(R.drawable.baseline_favorite_border_24)
    }
    override val root: View
        get() = horizontalLayout {
            this.padding = dp(16)
            add(corner4Image, lParams(width = dp(100), height = dp(80)))

            add(verticalLayout {
                add(centerTitle, lParams {})
                add(centerSubTitle, lParams { })
            }, lParams(width = 0) {
                weight = 1f
                this.horizontalMargin = dp(16)
            })
            add(favIcon, lParams { })
        }

    fun renderUi(data: Item) {
        corner4Image.setImageResource(data.imageId)
        centerTitle.text = data.title
        centerSubTitle.text = data.subtitle
    }
}