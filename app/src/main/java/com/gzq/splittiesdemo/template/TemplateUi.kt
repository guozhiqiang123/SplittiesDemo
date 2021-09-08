package com.gzq.splittiesdemo.template

import android.content.Context
import android.view.View
import splitties.views.dsl.core.Ui
import splitties.views.dsl.core.textView

/**
 *date：2021/9/9 上午12:12
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class TemplateUi(override val ctx: Context) :Ui{
    override val root: View
        get() = textView {
            text="Template"
        }
}