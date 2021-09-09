package com.gzq.splittiesdemo.home.vertical

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ToggleButton
import com.gzq.splittiesdemo.common.corner4ImageView
import splitties.dimensions.dp
import splitties.resources.color
import splitties.views.dsl.core.*
import splitties.views.padding
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.data.Item
import splitties.resources.styledTxt

class VerticalListItemSmallImageUi(override val ctx: Context) : Ui {
    private val corner4Image = corner4ImageView() {
        scaleType = ImageView.ScaleType.CENTER_CROP
    }
    private val centerTitle = textView {
        textSize = 16f
        setTextColor(color(R.color.text_grey))
    }
    private val centerSubTitle = textView {
        textSize = 14f
        setTextColor(color(R.color.text_grey))
    }

    private val favIcon = ToggleButton(ctx).apply {

    }
    override val root: View
        get() = horizontalLayout {
            add(corner4Image, lParams(width = dp(100), height = dp(80)) {
                padding = dp(16)

            })
            add(verticalLayout {
                add(centerTitle, lParams {})
                add(centerSubTitle, lParams { })
            }, lParams(width = 0) {
                weight = 1f
            })
            add(favIcon, lParams { })
        }

    fun renderUi(data: Item) {
        corner4Image.setImageResource(data.imageId)
        centerTitle.text = data.title
        centerSubTitle.text = data.subtitle
    }
}