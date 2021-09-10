package com.gzq.splittiesdemo.home.vertical

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.data.Item
import com.gzq.splittiesdemo.function.ItemClick
import splitties.views.dsl.recyclerview.verticalListLayoutParams
import splitties.views.recyclerview.verticalLayoutManager

class VerticalListViewAdapter(
    private val listData: List<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mItemClick: ItemClick<Item>? = null

    val layoutManager = verticalLayoutManager()

    override fun getItemViewType(position: Int): Int {
        return listData[position].id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType % 3 == 0) SmallImageViewHolder(
            VerticalListItemSmallImageUi(parent.context),
            layoutManager
        )
        else BigImageViewHolder(
            VerticalListItemBigImageUi(parent.context),
            layoutManager
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (listData[position].id % 3 == 0) {
            val smallHolder = holder as SmallImageViewHolder
            smallHolder.ui.renderUi(data = listData[position])
        } else {
            val bigHolder = holder as BigImageViewHolder
            bigHolder.ui.renderUi(data = listData[position])
            bigHolder.itemView.setOnClickListener {
                mItemClick?.onItemClick(position, listData[position])
            }
        }
    }

    override fun getItemCount(): Int = listData.size

    /**
     * item的点击事件
     */
    fun setOnItemClickListener(itemClick: ItemClick<Item>) {
        mItemClick = itemClick
    }

    class BigImageViewHolder(
        val ui: VerticalListItemBigImageUi,
        layoutManager: RecyclerView.LayoutManager
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