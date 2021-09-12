package com.gzq.splittiesdemo.home.grid

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.data.DemoDataProvider
import splitties.resources.color
import splitties.views.backgroundColor
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.core.*
import splitties.views.dsl.recyclerview.recyclerView
import splitties.views.recyclerview.gridLayoutManager

/**
 *date：2021/9/12 下午8:26
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class GridListMainUi(override val ctx: Context) : Ui {
    //顶部导航条
    val toolbar = toolbar {
        backgroundColor = color(R.color.green_500)
        setTitle(R.string.list_view)
        setTitleTextColor(color(R.color.text_white))
        setSubtitle(R.string.subtitle_grid)
        setSubtitleTextColor(color(R.color.text_white))
        setNavigationIcon(R.drawable.baseline_arrow_back_24)
    }

    private val mAdapter = GridListAdapter(
        DemoDataProvider.itemList.take(4).map {
            GridListActivity.GridData(GridListActivity.GridData.TYPE_IMAGE, imageData = it)
        }.toMutableList().apply {
            addAll(DemoDataProvider.tweetList.map {
                GridListActivity.GridData(GridListActivity.GridData.TYPE_AVATAR, avatarData = it)
            })
        })

    override val root: View
        get() = verticalLayout {
            add(toolbar, lParams(width = matchParent))

            add(recyclerView {
                val mLayoutManager = gridLayoutManager(spanCount = 4)
                layoutManager = mLayoutManager
                mLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (position < 4) 2
                        else 1
                    }
                }
                adapter = mAdapter

            }, lParams(width = matchParent, height = matchParent))
        }
}