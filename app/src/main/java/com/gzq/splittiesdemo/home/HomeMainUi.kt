package com.gzq.splittiesdemo.home

import android.content.Context
import android.view.View
import com.gzq.splittiesdemo.R
import splitties.resources.color
import splitties.views.backgroundColor
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.constraintlayout.lParams
import splitties.views.dsl.core.*

/**
 *company：成都标学科技有限公司
 *date：2021/9/5 下午8:25
 *coder：gzq
 *email：guozhiqiang@zlketang.com
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

    override val root: View
        get() = verticalLayout {
            //导航条
            add(toolbar, lParams(width = matchParent))
            //内容区
            add(textView { text = "测试" }, lParams())
        }
}