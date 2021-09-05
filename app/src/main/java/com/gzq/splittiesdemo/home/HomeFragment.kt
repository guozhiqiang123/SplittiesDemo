package com.gzq.splittiesdemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gzq.splittiesdemo.HelloWorldUi
import com.gzq.splittiesdemo.R

/**
 *date：2021/9/5 下午8:38
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class HomeFragment : Fragment() {
    private val vm by viewModels<HomeMainVM>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return HomeMainUi(requireContext()).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.fetchData()
    }

    companion object {
        fun instance(): HomeFragment {
            return HomeFragment()
        }
    }
}