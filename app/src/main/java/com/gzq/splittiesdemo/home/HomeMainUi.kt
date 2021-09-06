package com.gzq.splittiesdemo.home

import android.content.Context
import android.view.View
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.function.ItemClick
import splitties.resources.color
import splitties.toast.toast
import splitties.views.backgroundColor
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.core.*
import splitties.views.dsl.recyclerview.recyclerView
import splitties.views.setPaddingDp

/**
 *date：2021/9/5 下午8:25
 *coder：gzq
 *email：774550196@qq.com
 *description: Home的主页面
 */

class HomeMainUi(override val ctx: Context) : Ui {
    //顶部导航条
    private val toolbar = toolbar {
        inflateMenu(R.menu.home_main_function_menu)
        backgroundColor = color(R.color.green_500)
        setTitle(R.string.app_name)
        setTitleTextColor(color(R.color.text_white))
    }


    val mAdapter by lazy { HomeMainAdapter() }

    //菜单list
    private val list = recyclerView {
        clipToPadding = false
        setPaddingDp(top = 16)
        setHasFixedSize(true)
        adapter = mAdapter
        layoutManager = mAdapter.layoutManager
    }

    override val root: View
        get() = verticalLayout {
            //导航条
            add(toolbar, lParams(width = matchParent))
            //内容区
            add(list, lParams(height = matchParent, width = matchParent))
        }
}