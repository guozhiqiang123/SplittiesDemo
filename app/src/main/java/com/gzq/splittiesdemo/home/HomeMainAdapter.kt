package com.gzq.splittiesdemo.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.shape
import com.gzq.splittiesdemo.function.ItemClick
import com.gzq.splittiesdemo.recyclerview.BaseViewHolder
import splitties.dimensions.dp
import splitties.init.appCtx
import splitties.resources.color
import splitties.views.dsl.constraintlayout.centerInParent
import splitties.views.dsl.constraintlayout.lParams
import splitties.views.dsl.core.add
import splitties.views.dsl.core.matchParent
import splitties.views.dsl.core.textView
import splitties.views.dsl.core.wrapContent
import splitties.views.dsl.material.shapeableImageView
import splitties.views.dsl.recyclerview.verticalListLayoutParams
import splitties.views.recyclerview.verticalLayoutManager
import splitties.views.setPaddingDp

/**
 *company：成都环宇知了科技有限公司
 *date：2021/9/6 下午5:27
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

class HomeMainAdapter : RecyclerView.Adapter<HomeMainAdapter.MyViewHolder>() {

    val layoutManager = verticalLayoutManager()

    private val mData = arrayListOf<HomeMainItemData>()

    private var mItemClick: ItemClick<HomeMainItemData>? = null

    /**
     * 更新数据
     */
    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<HomeMainItemData>) {
        mData.addAll(data)
        notifyDataSetChanged()
    }

    /**
     * item的点击事件
     */
    fun setOnItemClickListener(itemClick: ItemClick<HomeMainItemData>) {
        mItemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(parent.context, layoutManager, mItemClick)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(mData[position])


    override fun getItemCount(): Int = mData.size

    class MyViewHolder(
        ctx: Context,
        layoutManager: RecyclerView.LayoutManager,
        itemClick: ItemClick<HomeMainItemData>?
    ) : BaseViewHolder<HomeMainItemData, HomeMainItemUi>(HomeMainItemUi(ctx)) {
        init {
            //设置整个itemView的LayoutParams，可以使用提供的verticalListLayoutParams和horizontalListLayoutParams
            //也可以自己定义，但一定是RecyclerView.LayoutParams
            val verticalListLayoutParams = layoutManager.verticalListLayoutParams()
            verticalListLayoutParams.setMargins(
                ctx.dp(16),
                ctx.dp(12),
                ctx.dp(16),
                ctx.dp(12)
            )
            itemRoot.layoutParams = verticalListLayoutParams
            itemRoot.setOnClickListener { itemClick?.onItemClick(bindingAdapterPosition, data) }
        }

        override fun HomeMainItemUi.onBind() {
            textView.text = data.name
        }
    }
}

/**
 * Item的布局
 */
class HomeMainItemUi @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val textView = textView {
        textSize = 14f
        setTextColor(color(R.color.text_white))
    }

    init {
        background = shape(solidColor = color(R.color.green_500), radius = dp(4F))
        add(textView, lParams(width = wrapContent, height = wrapContent) {
            centerInParent()
            setPaddingDp(top = 12, bottom = 12)
        })
    }

}