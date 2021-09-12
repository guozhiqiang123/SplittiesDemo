package com.gzq.splittiesdemo.home.horizontal

import android.content.Context
import android.view.View
import com.chad.library.adapter.base.BaseBinderAdapter
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.splitView
import com.gzq.splittiesdemo.data.DemoDataProvider
import splitties.dimensions.dp
import splitties.resources.color
import splitties.resources.str
import splitties.views.backgroundColor
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.core.*
import splitties.views.dsl.recyclerview.recyclerView
import splitties.views.padding
import splitties.views.recyclerview.horizontalLayoutManager
import splitties.views.setPaddingDp

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

    //    val avatarAdapter = BaseBinderAdapter(list = DemoDataProvider.tweetList.toMutableList()).apply {
//        addItemBinder(AvatarItemSolidBinder())
//        addItemBinder(AvatarItemGradientBinder())
//    }
    val avatarAdapter = AvatarItemAdapter(DemoDataProvider.tweetList.toMutableList())

    override val root: View
        get() = verticalLayout {
            add(toolbar, lParams(width = matchParent) { })
            add(textView(theme = R.style.tv_normal_16sp_grey) {
                setPaddingDp(start = 16, end = 16, top = 16)
                text = str(R.string.good_food)
            }, lParams { })
            add(recyclerView {
                isHorizontalScrollBarEnabled = false
                layoutManager = mAdapter.layoutManager
                adapter = mAdapter
            }, lParams(width = matchParent) { })

            //分割线
            add(splitView {
                setBackgroundColor(color(R.color.split_grey))
            }, lParams(matchParent, dp(1)) {
                startMargin = dp(16)
                endMargin = dp(16)
            })
            add(textView(theme = R.style.tv_normal_16sp_grey) {
                padding=dp(16)
                text = "Stories"
            }, lParams { })

            //人物头像
            add(recyclerView {
                isHorizontalScrollBarEnabled = false
                layoutManager = horizontalLayoutManager()
                adapter = avatarAdapter
            }, lParams(matchParent, dp(80)) {

            })
        }
}