package com.gzq.splittiesdemo.common

import android.content.res.ColorStateList
import android.view.View
import androidx.annotation.*
import com.gzq.splittiesdemo.R
import splitties.resources.appColor
import splitties.resources.colorSL
import splitties.views.dsl.appcompat.toolbar

/**
 *company：成都标学科技有限公司
 *date：2021/9/5 下午6:42
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

/**
 * 公用Toolbar
 */
fun View.defaultToolbar(
    title: String? = null,
    @StringRes titleRes: Int? = null,
    @ColorInt bgColor: Int? = null,
    @ColorRes bgColorRes: Int? = R.color.green_500,
    @ColorInt titleTextColor: Int? = appColor(R.color.text_black),
    titleTextColorSL: ColorStateList? = null,
    @DrawableRes navigationIconRes: Int? = null,
    @DrawableRes collapseIconRes: Int? = null,
    @MenuRes menuRes: Int? = null,
) = toolbar {
    menuRes?.apply { inflateMenu(this) }
    bgColor?.apply { setBackgroundColor(this) }
    bgColorRes?.apply { setBackgroundResource(this) }
    title?.apply { setTitle(this) }
    titleRes?.apply { setTitle(this) }
    titleTextColor?.apply { setTitleTextColor(this) }
    titleTextColorSL?.apply { setTitleTextColor(this) }
    navigationIconRes?.apply { setNavigationIcon(this) }
    collapseIconRes?.apply { setCollapseIcon(this) }
}