package com.gzq.splittiesdemo.home.grid

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.annotation.IntDef
import com.gzq.splittiesdemo.common.BaseActivity
import com.gzq.splittiesdemo.data.Item
import com.gzq.splittiesdemo.data.Tweet
import splitties.checkedlazy.mainThreadLazy
import splitties.views.dsl.core.setContentView

/**
 *date：2021/9/12 下午8:25
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class GridListActivity : BaseActivity() {
    private val ui by mainThreadLazy { GridListMainUi(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui)

        ui.toolbar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }

    data class GridData(
        @GridListType val type: Int,
        val imageData: Item? = null,
        val avatarData: Tweet? = null
    ) {
        @Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
        @MustBeDocumented
        @IntDef(
            TYPE_IMAGE,
            TYPE_AVATAR,
        )
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        annotation class GridListType
        companion object {
            const val TYPE_IMAGE = 1
            const val TYPE_AVATAR = 2
        }
    }
}

