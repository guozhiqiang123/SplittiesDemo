package com.gzq.splittiesdemo.demoui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gzq.splittiesdemo.common.BaseFragment
import splitties.checkedlazy.mainThreadLazy

/**
 *date：2021/9/9 上午12:06
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class DemoUiFragment : BaseFragment() {
    private val ui by mainThreadLazy { DemoUiMainUi(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ui.root

    companion object {
        fun instance(): DemoUiFragment = DemoUiFragment()
    }
}