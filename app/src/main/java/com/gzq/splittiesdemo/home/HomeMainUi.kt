package com.gzq.splittiesdemo.home

import android.content.Context
import android.view.View
import com.gzq.splittiesdemo.R
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

    override val root: View
        get() = verticalLayout {
            //导航条
            add(toolbar, lParams(width = matchParent))
            //内容区
            add(recyclerView {
                clipToPadding = false
                setPaddingDp(top = 16)
                setHasFixedSize(true)
                val data = arrayListOf(
                    HomeMainItemData("第一行", 0),
                    HomeMainItemData("第二行", 1)
                )
                val mAdapter = HomeMainAdapter(data, object :
                    HomeMainAdapter.MyViewHolder.Host {
                    override fun onItemClick(position: Int, itemData: HomeMainItemData) {
                        toast(itemData.name)
                    }
                })
                adapter = mAdapter
                layoutManager = mAdapter.layoutManager
            }, lParams(height = matchParent, width = matchParent))
        }
}