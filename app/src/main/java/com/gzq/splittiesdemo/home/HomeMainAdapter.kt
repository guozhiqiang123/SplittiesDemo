package com.gzq.splittiesdemo.home

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.gzq.splittiesdemo.R
import splitties.resources.color
import splitties.typesaferecyclerview.ItemViewHolder
import splitties.views.dsl.constraintlayout.centerInParent
import splitties.views.dsl.constraintlayout.lParams
import splitties.views.dsl.core.add
import splitties.views.dsl.core.matchParent
import splitties.views.dsl.core.textView
import splitties.views.dsl.core.wrapContent
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

class HomeMainAdapter(
    private val data: List<HomeMainItemData>,
    private val host: MyViewHolder.Host
) : RecyclerView.Adapter<HomeMainAdapter.MyViewHolder>() {

    val layoutManager = verticalLayoutManager()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(parent.context, layoutManager, host)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class MyViewHolder(
        ctx: Context,
        layoutManager: RecyclerView.LayoutManager,
        host: Host
    ) : ItemViewHolder<HomeMainItemData, HomeMainItemUi, MyViewHolder.Host>(
        host,
        HomeMainItemUi(ctx)
    ) {
        init {
            itemView.layoutParams = layoutManager.verticalListLayoutParams()
            itemView.setOnClickListener { host.onItemClick(bindingAdapterPosition, data) }
        }

        override fun HomeMainItemUi.onBind() {
            textView.text = data.name
        }

        interface Host {
            fun onItemClick(position: Int, itemData: HomeMainItemData)
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
        textSize = 14F
        setTextColor(color(R.color.black))
    }

    init {
        add(textView, lParams(width = matchParent, height = wrapContent) {
            centerInParent()
            setPaddingDp(top = 12, bottom = 12)
        })
    }

}