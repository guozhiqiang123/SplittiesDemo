package com.gzq.splittiesdemo

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.gzq.splittiesdemo.anim.AnimFragment
import com.gzq.splittiesdemo.common.BaseActivity
import com.gzq.splittiesdemo.common.BaseFragment
import com.gzq.splittiesdemo.demoui.DemoUiFragment
import com.gzq.splittiesdemo.home.HomeFragment
import com.gzq.splittiesdemo.main.MainUi
import com.gzq.splittiesdemo.template.TemplateFragment
import com.gzq.splittiesdemo.widgets.WidgetsFragment
import splitties.checkedlazy.mainThreadLazy
import splitties.fragments.fragmentTransaction
import splitties.toast.toast
import splitties.views.dsl.core.setContentView

class MainActivity : BaseActivity() {

    private val ui by mainThreadLazy { MainUi(this) }

    private lateinit var homeFragment: HomeFragment
    private lateinit var widgetsFragment: WidgetsFragment
    private lateinit var animFragment: AnimFragment
    private lateinit var demoUiFragment: DemoUiFragment
    private lateinit var templateFragment: TemplateFragment

    private var currentFragment: BaseFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui)
        if (savedInstanceState != null) {
            homeFragment =
                supportFragmentManager.findFragmentByTag(HomeFragment::class.simpleName) as? HomeFragment
                    ?: HomeFragment.instance()
            widgetsFragment =
                supportFragmentManager.findFragmentByTag(WidgetsFragment::class.simpleName) as? WidgetsFragment
                    ?: WidgetsFragment.instance()
            animFragment =
                supportFragmentManager.findFragmentByTag(AnimFragment::class.simpleName) as? AnimFragment
                    ?: AnimFragment.instance()
            demoUiFragment =
                supportFragmentManager.findFragmentByTag(DemoUiFragment::class.simpleName) as? DemoUiFragment
                    ?: DemoUiFragment.instance()
            templateFragment =
                supportFragmentManager.findFragmentByTag(TemplateFragment::class.simpleName) as? TemplateFragment
                    ?: TemplateFragment.instance()
        } else {
            homeFragment = HomeFragment.instance()
            widgetsFragment = WidgetsFragment.instance()
            animFragment = AnimFragment.instance()
            demoUiFragment = DemoUiFragment.instance()
            templateFragment = TemplateFragment.instance()
        }
        showFragment(homeFragment)

        ui.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> showFragment(homeFragment)
                R.id.action_widgets -> showFragment(widgetsFragment)
                R.id.action_anim -> showFragment(animFragment)
                R.id.action_demo_ui -> showFragment(demoUiFragment)
                R.id.action_template -> showFragment(templateFragment)
                else -> throw error("程序异常")
            }
            true
        }
    }

    private fun showFragment(show: BaseFragment) {
        fragmentTransaction {
            currentFragment?.run { hide(this) }
            if (show.isAdded.not()) {
                add(R.id.main_fragment_container, show, show.javaClass.simpleName)
            } else {
                show(show)
            }
            currentFragment = show
        }
    }
}