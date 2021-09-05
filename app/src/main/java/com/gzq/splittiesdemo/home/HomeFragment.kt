package com.gzq.splittiesdemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gzq.splittiesdemo.HelloWorldUi
import com.gzq.splittiesdemo.R

/**
 *company：成都标学科技有限公司
 *date：2021/9/5 下午8:38
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return HomeMainUi(requireContext()).root
    }

    companion object {
        fun instance(): HomeFragment {
            return HomeFragment()
        }
    }
}