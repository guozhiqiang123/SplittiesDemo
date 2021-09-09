package com.gzq.splittiesdemo.home.vertical

import android.os.Bundle
import com.gzq.splittiesdemo.common.BaseActivity
import splitties.checkedlazy.mainThreadLazy
import splitties.views.dsl.core.setContentView

/**
 *date：2021/9/9 下午9:39
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class VerticalListViewActivity : BaseActivity() {

    private val ui by mainThreadLazy { VerticalListViewUi(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui)



    }
}