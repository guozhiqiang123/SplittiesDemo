package com.gzq.splittiesdemo.home.vertical

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.data.Item
import com.gzq.splittiesdemo.function.ItemClick
import splitties.views.dsl.recyclerview.verticalListLayoutParams
import splitties.views.recyclerview.verticalLayoutManager

/**
 * 这里演示的是Recyclerview最原始的写法，包括多布局
 */
class VerticalListViewAdapter(
    private val listData: MutableList<Item>
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
            smallHolder.ui.favIcon.setOnClickListener {
                val oldItem = listData[position]
                val newItem = oldItem.copy(isLike = !oldItem.isLike)
                listData[position] = newItem
                notifyItemChanged(position, newItem)
            }
        } else {
            val bigHolder = holder as BigImageViewHolder
            bigHolder.ui.renderUi(data = listData[position])
            //Item的点击事件
            bigHolder.itemView.setOnClickListener {
                mItemClick?.onItemClick(position, listData[position])
            }
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        //防止闪烁
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position)
        } else {
            val item = payloads[0] as? Item
            item?.run {
                if (item.id % 3 == 0) {
                    val smallHolder = holder as SmallImageViewHolder
                    smallHolder.ui.updateFavIconState(item.isLike)
                } else {
                    //nothing
                }
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
            //必须给每一个Item设置LP，否则布局测量次数太多，影响性能
            itemView.layoutParams = layoutManager.verticalListLayoutParams()
        }
    }

    class SmallImageViewHolder(
        val ui: VerticalListItemSmallImageUi,
        layoutManager: RecyclerView.LayoutManager,
    ) :
        RecyclerView.ViewHolder(ui.root) {
        init {
            //必须给每一个Item设置LP，否则布局测量次数太多，影响性能
            itemView.layoutParams = layoutManager.verticalListLayoutParams()
        }
    }
}