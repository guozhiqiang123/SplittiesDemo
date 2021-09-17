package com.gzq.splittiesdemo.home

import android.content.Context
import android.util.AttributeSet
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.mediumTextView
import com.gzq.splittiesdemo.common.shape
import splitties.dimensions.dp
import splitties.resources.color
import splitties.views.dsl.constraintlayout.centerInParent
import splitties.views.dsl.constraintlayout.lParams
import splitties.views.dsl.core.add
import splitties.views.dsl.core.wrapContent
import splitties.views.selectable.constraintlayout.SelectableConstraintLayout
import splitties.views.setPaddingDp

class HomeMainItemUi(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SelectableConstraintLayout(context, attrs, defStyleAttr) {

    val textView = mediumTextView {
        textSize = 14f
        setTextColor(color(R.color.text_white))
    }

    init {
        background = shape(solidColorRes = R.color.green_500, radius = dp(4F))
        add(textView, lParams(width = wrapContent, height = wrapContent) {
            centerInParent()
            setPaddingDp(top = 12, bottom = 12)
        })
    }

}