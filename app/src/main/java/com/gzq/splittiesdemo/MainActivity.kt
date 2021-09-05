package com.gzq.splittiesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gzq.splittiesdemo.home.HomeFragment
import com.gzq.splittiesdemo.main.MainUi
import splitties.fragments.fragmentTransaction
import splitties.views.dsl.core.setContentView

class MainActivity : AppCompatActivity() {

    private val viewModel = viewModels<HelloWorldVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ui = MainUi(this)
        setContentView(ui)
        fragmentTransaction(now = true) {
            add(R.id.main_fragment_container, HomeFragment.instance())
        }
    }
}