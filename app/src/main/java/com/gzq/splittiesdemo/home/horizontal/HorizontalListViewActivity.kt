package com.gzq.splittiesdemo.home.horizontal

import android.os.Bundle
import com.gzq.splittiesdemo.common.BaseActivity
import splitties.checkedlazy.mainThreadLazy
import splitties.views.dsl.core.setContentView

/**
 *date：2021/9/10 下午9:52
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class HorizontalListViewActivity : BaseActivity() {
    private val ui by mainThreadLazy { HorizontalListViewUi(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui)
    }
}