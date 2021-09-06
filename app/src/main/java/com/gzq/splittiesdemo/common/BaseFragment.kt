package com.gzq.splittiesdemo.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *date：2021/9/7 上午12:13
 *coder：gzq
 *email：774550196@qq.com
 *description:预留BaseFragment，可以处理公共业务
 */

abstract class BaseFragment : Fragment() {
    abstract override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
}