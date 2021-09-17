package com.gzq.splittiesdemo.demoui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.function.ItemClick
import com.gzq.splittiesdemo.home.HomeMainItemData
import com.gzq.splittiesdemo.home.HomeMainItemUi
import splitties.dimensions.dp

class DemoMainAdapter(
    private val listData: MutableList<HomeMainItemData>,
    private val itemClick: ItemClick<HomeMainItemData>?
) : RecyclerView.Adapter<DemoMainAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(HomeMainItemUi(parent.context))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ui.textView.text = listData[position].name
        holder.itemView.setOnClickListener {
            itemClick?.onItemClick(position, listData[position])
        }
    }

    override fun getItemCount(): Int = listData.size

    class MyViewHolder(val ui: HomeMainItemUi) : RecyclerView.ViewHolder(ui) {
        init {
            val layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(
                itemView.context.dp(16),
                itemView.context.dp(12),
                itemView.context.dp(16),
                itemView.context.dp(12)
            )
            itemView.layoutParams = layoutParams
        }
    }
}