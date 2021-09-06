package com.gzq.splittiesdemo.recyclerview

import android.view.View
import splitties.views.inflate
import androidx.recyclerview.widget.RecyclerView
import androidx.annotation.LayoutRes
import android.view.ViewGroup

/**
 * date：2021/9/6 下午9:28
 * coder：gzq
 * email：774550196@qq.com
 * description:
 */
abstract class BaseViewHolder<Data : Any, V : View>(
    val itemRoot: V
) : RecyclerView.ViewHolder(itemRoot) {
    /**
     * This property is updated from [bind] before [onBind] is called.
     */
    lateinit var data: Data
        private set

    /**
     * Don't create objects, use non inlined lambdas, or call methods doing so in this callback
     * as it may be called a lot of times as the user scrolls faster and faster, and allocating
     * memory could affect the UI smoothness.
     * @see data
     * @see bind
     */
    protected abstract fun V.onBind()

    /** To be called from your [RecyclerView.Adapter.onBindViewHolder] implementation. */
    fun bind(newData: Data) {
        data = newData
        itemRoot.onBind()
    }
}