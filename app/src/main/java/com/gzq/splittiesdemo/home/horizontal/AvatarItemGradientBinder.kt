package com.gzq.splittiesdemo.home.horizontal

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.binder.BaseItemBinder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.gzq.splittiesdemo.data.Tweet
import splitties.dimensions.dp
import splitties.init.appCtx

/**
 *company：成都环宇知了科技有限公司
 *date：2021/9/11 上午11:00
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:渐变描边头像Binder
 */
@Deprecated(message = "不适合使用这种方式")
class AvatarItemGradientBinder :
    BaseItemBinder<Tweet, AvatarItemGradientBinder.MyViewHolder>() {

    override fun convert(holder: MyViewHolder, data: Tweet) {
        holder.ui.renderUi(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(AvatarItemUiGradient((parent.context)))
    }

    class MyViewHolder(val ui: AvatarItemUiGradient) : BaseViewHolder(ui.root) {
        init {
            val layoutParams = RecyclerView.LayoutParams(appCtx.dp(60), appCtx.dp(60))
            layoutParams.leftMargin = appCtx.dp(12)
            itemView.layoutParams = layoutParams
        }
    }
}