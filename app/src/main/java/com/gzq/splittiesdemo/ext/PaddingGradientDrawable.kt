package com.gzq.splittiesdemo.ext

import android.graphics.Rect
import android.graphics.drawable.GradientDrawable

/**
 *company：成都环宇知了科技有限公司
 *date：2021/9/10 下午5:06
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:兼容低版本设置padding的GradientDrawable
 * 官方的GradientDrawables#setPadding支持android10及以上
 *
 */

open class PaddingGradientDrawable : GradientDrawable() {
    private var mPadding: Rect? = null

    override fun getPadding(padding: Rect): Boolean {
        return if (mPadding != null) {
            padding.set(mPadding!!)
            true
        } else {
            super.getPadding(padding)
        }
    }

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        if (mPadding == null) {
            mPadding = Rect()
        }
        mPadding!!.set(left, top, right, bottom)
        invalidateSelf()
    }

}