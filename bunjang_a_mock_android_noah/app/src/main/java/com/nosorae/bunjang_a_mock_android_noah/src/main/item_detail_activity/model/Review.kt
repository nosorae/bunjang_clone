package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model

data class Review(
    val contents: String,
    val productName: String,
    val reviewId: Int,
    val reviewImgUrl: String,
    val starRating: Int,
    val storeId: Int,
    val storeImgUrl: Any,
    val storeName: String,
    val time: String
)