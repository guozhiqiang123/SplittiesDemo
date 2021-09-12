package com.gzq.splittiesdemo.home.horizontal

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.data.Tweet
import com.gzq.splittiesdemo.function.ItemClick
import splitties.dimensions.dp
import splitties.init.appCtx

/**
 *date：2021/9/12 下午6:29
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class AvatarItemAdapter(val listData: MutableList<Tweet>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemClick: ItemClick<Tweet>? = null

    fun setOnItemClickListener(itemClick: ItemClick<Tweet>) {
        this.itemClick = itemClick
    }

    override fun getItemViewType(position: Int): Int {
        return listData[position].id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            SolidViewHolder(AvatarItemUiSolid(parent.context))
        } else {
            GradientViewHolder(AvatarItemUiGradient(parent.context))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val tweet = listData[position]
        if (tweet.id == 1) {
            val solidViewHolder = holder as SolidViewHolder
            solidViewHolder.ui.renderUi(tweet)
        } else {
            val gradientViewHolder = holder as GradientViewHolder
            gradientViewHolder.ui.renderUi(tweet)
        }
        //item点击事件
        holder.itemView.setOnClickListener {
            itemClick?.onItemClick(position, listData[position])
        }
    }

    override fun getItemCount(): Int = listData.size

    class SolidViewHolder(val ui: AvatarItemUiSolid) : RecyclerView.ViewHolder(ui.root) {
        init {
            val layoutParams =
                RecyclerView.LayoutParams(appCtx.dp(60), RecyclerView.LayoutParams.WRAP_CONTENT)
            layoutParams.leftMargin = appCtx.dp(12)
            itemView.layoutParams = layoutParams
        }
    }

    class GradientViewHolder(val ui: AvatarItemUiGradient) : RecyclerView.ViewHolder(ui.root) {
        init {
            val layoutParams =
                RecyclerView.LayoutParams(appCtx.dp(60), RecyclerView.LayoutParams.WRAP_CONTENT)
            layoutParams.leftMargin = appCtx.dp(12)
            itemView.layoutParams = layoutParams
        }
    }

}