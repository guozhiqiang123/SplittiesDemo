package com.gzq.splittiesdemo.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gzq.splittiesdemo.common.BaseFragment
import splitties.checkedlazy.mainThreadLazy

/**
 *date：2021/9/9 上午12:11
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class TemplateFragment : BaseFragment() {
    private val ui by mainThreadLazy { TemplateUi(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ui.root

    companion object {
        fun instance() = TemplateFragment()
    }
}