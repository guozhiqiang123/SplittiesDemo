package com.gzq.splittiesdemo.common

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.annotation.*
import androidx.core.view.doOnPreDraw
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.gzq.splittiesdemo.R
import splitties.dimensions.dp
import splitties.resources.appColor
import splitties.resources.colorSL
import splitties.views.dsl.appcompat.toolbar
import splitties.views.dsl.core.NO_THEME
import splitties.views.dsl.core.Ui
import splitties.views.dsl.core.textView
import splitties.views.dsl.material.shapeableImageView
import kotlin.OptIn
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 *date：2021/9/5 下午6:42
 *coder：gzq
 *email：774550196@qq.com
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

/**
 * 中粗TextView，弥补系统子重的不足
 */
@ExperimentalContracts
inline fun Context.mediumTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = NO_THEME,
    initView: TextView.() -> Unit = {}
): TextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return textView(id, theme) {
        doOnPreDraw {
            paint.strokeWidth = 2F
            paint.style = Paint.Style.FILL_AND_STROKE
        }
        initView.invoke(this)
    }
}

/**
 * 中粗TextView，弥补系统子重的不足
 */
inline fun View.mediumTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = NO_THEME,
    initView: TextView.() -> Unit = {}
): TextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return textView(id, theme) {
        doOnPreDraw {
            paint.strokeWidth = 2F
            paint.style = Paint.Style.FILL_AND_STROKE
        }
        initView.invoke(this)
    }
}

/**
 * 中粗TextView，弥补系统子重的不足
 */
inline fun Ui.mediumTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = NO_THEME,
    initView: TextView.() -> Unit = {}
): TextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return textView(id, theme) {
        doOnPreDraw {
            paint.strokeWidth = 2F
            paint.style = Paint.Style.FILL_AND_STROKE
        }
        initView.invoke(this)
    }
}

/**
 * 4dp圆角ImageView
 */
inline fun Ui.corner4ImageView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = NO_THEME,
    initView: ShapeableImageView.() -> Unit = {}
): ShapeableImageView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return shapeableImageView(id, theme) {
        shapeAppearanceModel = ShapeAppearanceModel.Builder()
            .setAllCornerSizes(dp(4F))
            .build()
        initView.invoke(this)
    }
}
