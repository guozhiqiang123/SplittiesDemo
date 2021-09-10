package com.gzq.splittiesdemo.home.vertical

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shape
import com.gzq.splittiesdemo.data.DemoDataProvider
import splitties.dimensions.dp
import splitties.views.dsl.core.Ui
import splitties.views.dsl.recyclerview.recyclerView

/**
 *date：2021/9/9 下午9:41
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class VerticalListViewUi(override val ctx: Context) : Ui {

    val mAdapter by lazy { VerticalListViewAdapter(DemoDataProvider.itemList) }

    override val root: View
        get() = recyclerView {

            adapter = mAdapter
            layoutManager = mAdapter.layoutManager
            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            //设置1dp高的分割线
            divider.setDrawable(
                shape(
                    solidColorRes = R.color.split_grey,
                    sizeHeight = dp(1),
                    marginStart = dp(16),
                    marginEnd = dp(16)
                )
            )
            addItemDecoration(divider)
        }
}

