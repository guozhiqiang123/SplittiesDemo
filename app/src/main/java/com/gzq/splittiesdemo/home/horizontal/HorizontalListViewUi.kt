package com.gzq.splittiesdemo.home.horizontal

import android.content.Context
import android.view.View
import com.gzq.splittiesdemo.R
import splitties.dimensions.dp
import splitties.resources.color
import splitties.resources.str
import splitties.views.backgroundColor
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.core.*
import splitties.views.dsl.recyclerview.recyclerView
import splitties.views.padding
import splitties.views.recyclerview.horizontalLayoutManager

/**
 *date：2021/9/10 下午9:54
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class HorizontalListViewUi(override val ctx: Context) : Ui {
    //顶部导航条
    val toolbar = toolbar {
        backgroundColor = color(R.color.green_500)
        setTitle(R.string.list_view)
        setTitleTextColor(color(R.color.text_white))
        setSubtitle(R.string.subtitle_horizontal)
        setSubtitleTextColor(color(R.color.text_white))
        setNavigationIcon(R.drawable.baseline_arrow_back_24)
    }

    val mAdapter = HorizontalListViewAdapter()

    override val root: View
        get() = verticalLayout {
            add(toolbar, lParams(width = matchParent) { })
            add(textView(theme = R.style.tv_normal_16sp_grey) {
                padding = dp(16)
                text = str(R.string.good_food)
            }, lParams { })
            add(recyclerView {
                layoutManager = mAdapter.layoutManager
                adapter = mAdapter
            }, lParams(width = matchParent) { })
        }
}