package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model

data class GetMySellingResult(
    val productId: Int,
    val productImgUrl: String,
    val productName: String,
    val time: String,
    val price: Int?
)