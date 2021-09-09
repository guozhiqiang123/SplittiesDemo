package com.gzq.splittiesdemo.home.vertical

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.data.DemoDataProvider
import com.gzq.splittiesdemo.data.Item
import splitties.views.dsl.core.Ui
import splitties.views.dsl.recyclerview.recyclerView
import splitties.views.dsl.recyclerview.verticalListLayoutParams
import splitties.views.recyclerview.verticalLayoutManager

/**
 *date：2021/9/9 下午9:41
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class VerticalListViewUi(override val ctx: Context) : Ui {
    override val root: View
        get() = recyclerView {
            val mAdapter = VerticalListViewAdapter(DemoDataProvider.itemList)
            adapter = mAdapter
            layoutManager = mAdapter.layoutManager
        }
}

class VerticalListViewAdapter(
    private val listData: List<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val layoutManager = verticalLayoutManager()

    override fun getItemViewType(position: Int): Int {
        return listData[position].id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType % 3 == 0) SmallImageViewHolder(
            VerticalListItemSmallImageUi(parent.context),
            layoutManager
        )
        else BigImageViewHolder(VerticalListItemBigImageUi(parent.context), layoutManager)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (listData[position].id % 3 == 0) {
            val smallHolder = holder as SmallImageViewHolder
            smallHolder.ui.renderUi(data = listData[position])
        } else {
            val bigHolder = holder as BigImageViewHolder
            bigHolder.ui.renderUi(data = listData[position])
        }
    }

    override fun getItemCount(): Int = listData.size

    class BigImageViewHolder(
        val ui: VerticalListItemBigImageUi,
        layoutManager: RecyclerView.LayoutManager,
    ) :
        RecyclerView.ViewHolder(ui.root) {
        init {
            itemView.layoutParams = layoutManager.verticalListLayoutParams()
        }
    }

    class SmallImageViewHolder(
        val ui: VerticalListItemSmallImageUi,
        layoutManager: RecyclerView.LayoutManager,
    ) :
        RecyclerView.ViewHolder(ui.root) {
        init {
            itemView.layoutParams = layoutManager.verticalListLayoutParams()
        }
    }
}