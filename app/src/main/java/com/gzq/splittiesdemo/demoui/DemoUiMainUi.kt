package com.gzq.splittiesdemo.demoui

import android.content.Context
import android.view.View
import com.gzq.splittiesdemo.MainActivity
import com.gzq.splittiesdemo.function.ItemClick
import com.gzq.splittiesdemo.home.HomeMainItemData
import splitties.activities.start
import splitties.views.dsl.core.Ui
import splitties.views.dsl.core.textView
import splitties.views.dsl.recyclerview.recyclerView
import splitties.views.recyclerview.verticalLayoutManager

/**
 *date：2021/9/9 上午12:07
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class DemoUiMainUi(override val ctx: Context) : Ui {
    private val listData = arrayListOf<HomeMainItemData>(
        HomeMainItemData("Instagram", INSTAGRAM),
        HomeMainItemData("Twitter", TWITTER),
        HomeMainItemData("Gmail", GMAIL),
        HomeMainItemData("Youtube", YOUTUBE),
        HomeMainItemData("Spotify", SPOTIFY),
        HomeMainItemData("Youtube", YOUTUBE),
        HomeMainItemData("CryptoApp+MVVM", CRYPTOAPP_MVVM),
    )
    val mAdapter = DemoMainAdapter(listData, object : ItemClick<HomeMainItemData> {
        override fun onItemClick(position: Int, itemData: HomeMainItemData) {
            when (listData[position].position) {
                INSTAGRAM -> {
                    ctx.start<MainActivity> { }
                }
            }
        }
    })
    override val root: View
        get() = recyclerView {
            adapter = mAdapter
            layoutManager = verticalLayoutManager()
        }

    companion object {
        const val INSTAGRAM = 0
        const val TWITTER = 1
        const val GMAIL = 2
        const val YOUTUBE = 3
        const val SPOTIFY = 4
        const val CRYPTOAPP_MVVM = 5
    }
}