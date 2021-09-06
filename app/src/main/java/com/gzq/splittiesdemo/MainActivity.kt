package com.gzq.splittiesdemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gzq.splittiesdemo.home.HomeFragment
import com.gzq.splittiesdemo.main.MainUi
import splitties.checkedlazy.mainThreadLazy
import splitties.fragments.fragmentTransaction
import splitties.views.dsl.core.setContentView

class MainActivity : AppCompatActivity() {

    private val ui by mainThreadLazy { MainUi(this) }

    private val vm by viewModels<HelloWorldVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui)
        fragmentTransaction(now = true) {
            add(R.id.main_fragment_container, HomeFragment.instance())
        }
    }
}