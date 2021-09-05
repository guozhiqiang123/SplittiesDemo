package com.gzq.splittiesdemo.main

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.navigation.NavigationBarView
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.defaultToolbar
import splitties.resources.color
import splitties.resources.colorSL
import splitties.views.backgroundColor
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.constraintlayout.*
import splitties.views.dsl.core.*
import splitties.views.dsl.material.MaterialComponentsStyles
import splitties.views.dsl.material.navigationView

/**
 *date：2021/9/5 下午2:24
 *coder：gzq
 *email：774550196@qq.com
 *description:主界面的UI样式
 */

class MainUi(override val ctx: Context) : Ui {

    private val materialComponentsStyles = MaterialComponentsStyles(ctx)

    //底部导航条
    private val bottomNavigation = materialComponentsStyles.bottomNavigationView.default {
        inflateMenu(R.menu.main_navigation_menu)
        backgroundColor=color(R.color.green_500)
        labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        itemIconTintList = colorSL(R.color.selector_bottom_navigation)
        itemTextColor = colorSL(R.color.selector_bottom_navigation)
    }
    override val root: View
        get() = constraintLayout {
            //Fragment的容器
            add(
                frameLayout(id = R.id.main_fragment_container) { },
                lParams(width = matchParent) {
                    topOfParent()
                    bottomToTopOf(bottomNavigation)
                })
            //底部导航条
            add(bottomNavigation, lParams(width = matchParent, height = wrapContent) {
                bottomOfParent()
            })
        }
}