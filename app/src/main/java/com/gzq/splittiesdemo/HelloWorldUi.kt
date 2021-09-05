package com.gzq.splittiesdemo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.Observer
import splitties.dimensions.dp
import splitties.resources.color
import splitties.toast.toast
import splitties.views.dsl.constraintlayout.*
import splitties.views.dsl.core.*
import splitties.views.dsl.idepreview.UiPreView
import splitties.views.onClick

/**
 *company：成都标学科技有限公司
 *date：2021/9/4 下午4:57
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

class HelloWorldUi @JvmOverloads constructor(
    override val ctx: Context,
    private val viewModel: HelloWorldVM = HelloWorldVM()
) : Ui {

    val test = Observer<Int> {
        tx1.text = it.toString()
    }

    private val tx1 = textView {

    }

    private val tx2 = textView {
        text = "第二个文本"
    }
    override val root: View = constraintLayout {
        setBackgroundColor(color(R.color.pink_200))

        //文本1
        add(tx1, lParams(height = wrapContent) {
            topOfParent(margin = dp(12))
            startOfParent(margin = dp(12))
        })
        //文本二
        add(tx2, lParams(height = wrapContent) {
            topToBottomOf(tx1)
            startToStartOf(tx1)
        })
        //按钮
        add(button {
            text = "点我试试"
            onClick {
                toast("SURPRISE!!!")
            }
        }, lParams(width = dp(200), height = wrapContent) {
            centerInParent()
        })
    }
}

@Deprecated("For IDE preview only", level = DeprecationLevel.HIDDEN)
private class MainUiImplPreview(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : UiPreView(
    context = context.withTheme(R.style.Theme_SplittiesDemo),
    attrs = attrs,
    defStyleAttr = defStyleAttr,
    createUi = { HelloWorldUi(it) }
)