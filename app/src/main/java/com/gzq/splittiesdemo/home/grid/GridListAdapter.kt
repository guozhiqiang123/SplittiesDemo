package com.gzq.splittiesdemo.home.grid

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.home.horizontal.AvatarItemUiGradient
import splitties.dimensions.dp
import splitties.init.appCtx
import splitties.toast.toast
import splitties.views.dsl.core.margin

/**
 *date：2021/9/12 下午8:40
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class GridListAdapter(
    private val listData: MutableList<GridListActivity.GridData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return listData[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            GridListActivity.GridData.TYPE_IMAGE -> ImageViewHolder(GridItemImageUi(parent.context))
            GridListActivity.GridData.TYPE_AVATAR -> AvatarViewHolder(AvatarItemUiGradient(parent.context))
            else -> throw error("类型不正确")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> {
                holder.ui.renderUi(listData[position].imageData!!)
                holder.itemView.setOnClickListener {
                    toast(listData[position].imageData!!.title)
                }
            }
            is AvatarViewHolder -> {
                holder.ui.renderUi(listData[position].avatarData!!)
                holder.itemView.setOnClickListener {
                    toast("$position->${listData[position].avatarData!!.author}")
                }
            }
        }
    }

    override fun getItemCount(): Int = listData.size

    class ImageViewHolder(val ui: GridItemImageUi) : RecyclerView.ViewHolder(ui.root) {
        init {
            val mLayoutManager =
                RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, appCtx.dp(220))
            mLayoutManager.margin = itemView.context.dp(8)
            itemView.layoutParams = mLayoutManager
        }
    }

    class AvatarViewHolder(val ui: AvatarItemUiGradient) : RecyclerView.ViewHolder(ui.root) {
        init {
            val mLayoutManager = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
            mLayoutManager.margin = itemView.context.dp(8)
            itemView.layoutParams = mLayoutManager
        }
    }
}