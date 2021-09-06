package com.gzq.splittiesdemo.function

/**
 * date：2021/9/6 下午9:18
 * coder：gzq
 * email：774550196@qq.com
 * description:RecyclerView，ListView,ViewPage等控件的Item点击事件
 */
interface ItemClick<T> {
    /**
     * @param position 点击的位置
     * @param itemData 该item的数据Model
     */
    fun onItemClick(position: Int, itemData: T)
}