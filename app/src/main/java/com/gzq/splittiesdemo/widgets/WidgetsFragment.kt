package com.gzq.splittiesdemo.widgets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gzq.splittiesdemo.common.BaseFragment
import splitties.checkedlazy.mainThreadLazy

/**
 *date：2021/9/8 下午10:38
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class WidgetsFragment : BaseFragment() {
    private val ui by mainThreadLazy { WidgetsMainUi(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ui.root

    companion object {
        fun instance(): WidgetsFragment = WidgetsFragment()
    }
}