package com.gzq.splittiesdemo.home.horizontal

import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.data.DemoDataProvider
import com.gzq.splittiesdemo.data.Item
import splitties.dimensions.dp
import splitties.init.appCtx
import splitties.views.dsl.recyclerview.horizontalListLayoutParams
import splitties.views.recyclerview.horizontalLayoutManager

/**
 *date：2021/9/10 下午10:00
 *coder：gzq
 *email：774550196@qq.com
 *description:本Adapter演示BaseRecyclerViewAdapterHelper的使用
 */

class HorizontalListViewAdapter : BaseQuickAdapter<Item, BaseViewHolder>(
    R.layout.layout_no,
    DemoDataProvider.itemList.toMutableList()
) {
    val layoutManager = horizontalLayoutManager()

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return MyViewHolder(HorizontalListItemUi(parent.context), layoutManager)
    }

    override fun convert(holder: BaseViewHolder, item: Item) {
        val myViewHolder = holder as MyViewHolder
        myViewHolder.ui.renderUi(item)
    }

    class MyViewHolder(
        val ui: HorizontalListItemUi,
        layoutManager: LinearLayoutManager
    ) : BaseViewHolder(ui.root) {
        init {
            itemView.layoutParams =
                RecyclerView.LayoutParams(
                    appCtx.dp(280),
                    RecyclerView.LayoutParams.WRAP_CONTENT
                )
        }
    }
}