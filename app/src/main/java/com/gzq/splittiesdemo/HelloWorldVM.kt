package com.gzq.splittiesdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import splitties.mainhandler.mainHandler
import splitties.mainhandler.mainHandlerSync

/**
 *date：2021/9/4 下午9:11
 *coder：gzq
 *email：774550196@qq.com
 *description:
 */

class HelloWorldVM : ViewModel() {

    private val data: MutableLiveData<Int> by lazy { MutableLiveData() }

    fun getData(): LiveData<Int> = `data`

    /**
     * 模拟请求数据
     */
    fun fetchData(param1: Int, param2: String) {
        mainHandler.postDelayed({
            data.value = 20
        }, 3000)
    }
}