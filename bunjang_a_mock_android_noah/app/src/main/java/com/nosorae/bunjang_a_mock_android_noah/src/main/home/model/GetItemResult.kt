package com.nosorae.bunjang_a_mock_android_noah.src.main.home.model

data class GetItemResult(
    val productId: Int,
    val productImgUrl: String,
    val productName: String,
    val price: Int,
    val pickCount: Int,
    var isPick: Int
    )