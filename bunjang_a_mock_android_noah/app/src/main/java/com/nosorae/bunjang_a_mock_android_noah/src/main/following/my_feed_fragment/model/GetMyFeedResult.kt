package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model

data class GetMyFeedResult(
    val price: Int?,
    val productId: Int,
    val productImgUrl: String?,
    val productName: String,
    val storeId: Int,
    val storeImgUrl: Any,
    val storeName: String
)