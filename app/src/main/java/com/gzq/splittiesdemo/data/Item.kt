package com.gzq.splittiesdemo.data

data class Item(
    val id: Int,
    val title: String,
    val subtitle: String,
    val imageId: Int,
    val source: String = "demo source",
    val isLike: Boolean = false
)