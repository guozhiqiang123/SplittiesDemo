package com.gzq.splittiesdemo.home.vertical

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shape
import com.gzq.splittiesdemo.data.DemoDataProvider
import splitties.dimensions.dp
import splitties.resources.color
import splitties.views.backgroundColor
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.core.*
import splitties.views.dsl.recyclerview.recyclerView

/**
 *date：2021/9/9 下午9:41
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class VerticalListViewUi(override val ctx: Context) : Ui {

    //顶部导航条
    val toolbar = toolbar {
        backgroundColor = color(R.color.green_500)
        setTitle(R.string.list_view)
        setTitleTextColor(color(R.color.text_white))
        setSubtitle(R.string.subtitle_vertical)
        setSubtitleTextColor(color(R.color.text_white))
        setNavigationIcon(R.drawable.baseline_arrow_back_24)
    }

    val mAdapter by lazy { VerticalListViewAdapter(DemoDataProvider.itemList.toMutableList()) }

    override val root: View
        get() = verticalLayout {
            add(toolbar, lParams(width = matchParent) { })

            add(recyclerView {
                isVerticalScrollBarEnabled = false
                adapter = mAdapter
                layoutManager = mAdapter.layoutManager
                val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                //设置1dp高的分割线
                divider.setDrawable(
                    shape(
                        solidColorRes = R.color.split_grey,
                        sizeHeight = dp(1),
                        marginStart = dp(16),
                        marginEnd = dp(16)
                    )
                )
                addItemDecoration(divider)
            }, lParams(width = matchParent) { })
        }
}

