package com.gzq.splittiesdemo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gzq.splittiesdemo.HelloWorldUi
import com.gzq.splittiesdemo.MainActivity
import com.gzq.splittiesdemo.R
import com.gzq.splittiesdemo.common.BaseFragment
import com.gzq.splittiesdemo.function.ItemClick
import splitties.checkedlazy.mainThreadLazy
import splitties.exceptions.unsupported
import splitties.exceptions.unsupportedAction
import splitties.fragments.start
import splitties.toast.toast

/**
 *date：2021/9/5 下午8:38
 *coder：gzq
 *email：774550196@qq.com
 *description:Home主页面
 */

class HomeFragment : BaseFragment() {
    private val vm by viewModels<HomeMainVM>()

    private val ui by mainThreadLazy { HomeMainUi(requireContext()) }

    private val listData = arrayListOf(
        HomeMainItemData("Vertical ListView", VERTICAL_LISTVIEW),
        HomeMainItemData("Horizontal ListView", HORIZONTAL_LISTVIEW),
        HomeMainItemData("Grid ListView", GRID_LISTVIEW),
        HomeMainItemData("Modifiers", MODIFIERS),
        HomeMainItemData("Layouts", LAYOUTS),
        HomeMainItemData("Constraint Layout", CONSTRAINT_LAYOUT),
        HomeMainItemData("Motion Layout", MOTION_LAYOUT),
        HomeMainItemData("Advance Lists", ADVANCE_LISTS),
        HomeMainItemData("Custom Fling", CUSTOM_FLING),
        HomeMainItemData("Compose X Android views", COMPOSEX_ANDROID_VIEWS),
        HomeMainItemData("Carousel", CAROUSEL),
        HomeMainItemData("Dialogs", DIALOGS),
        HomeMainItemData("TabLayout", TABLAYOUT),
        HomeMainItemData("BottomSheets", BOTTOMSHEETS),
        HomeMainItemData("Pull refresh demos", PULL_REFRESH_DEMOS),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ui.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ui.mAdapter.setData(listData)

        ui.mAdapter.setOnItemClickListener(object : ItemClick<HomeMainItemData> {
            override fun onItemClick(position: Int, itemData: HomeMainItemData) {
                when (itemData.position) {
                    VERTICAL_LISTVIEW -> {
                        start<MainActivity> {

                        }
                    }
                    HORIZONTAL_LISTVIEW -> {
                    }
                    GRID_LISTVIEW -> {

                    }
                    MODIFIERS -> {

                    }
                    LAYOUTS -> {

                    }
                    CONSTRAINT_LAYOUT -> {

                    }
                    MOTION_LAYOUT -> {

                    }
                    ADVANCE_LISTS -> {

                    }
                    CUSTOM_FLING -> {

                    }
                    COMPOSEX_ANDROID_VIEWS -> {

                    }
                    CAROUSEL -> {

                    }
                    DIALOGS -> {

                    }
                    TABLAYOUT -> {

                    }
                    BOTTOMSHEETS -> {

                    }
                    PULL_REFRESH_DEMOS -> {

                    }
                    else -> unsupported("不支持的跳转")
                }
            }
        })
    }

    companion object {
        fun instance(): HomeFragment {
            return HomeFragment()
        }

        const val VERTICAL_LISTVIEW = 1
        const val HORIZONTAL_LISTVIEW = 2
        const val GRID_LISTVIEW = 3
        const val MODIFIERS = 4
        const val LAYOUTS = 5
        const val CONSTRAINT_LAYOUT = 6
        const val MOTION_LAYOUT = 7
        const val ADVANCE_LISTS = 8
        const val CUSTOM_FLING = 9
        const val COMPOSEX_ANDROID_VIEWS = 10
        const val CAROUSEL = 11
        const val DIALOGS = 12
        const val TABLAYOUT = 13
        const val BOTTOMSHEETS = 14
        const val PULL_REFRESH_DEMOS = 15
    }
}