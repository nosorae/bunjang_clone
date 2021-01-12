package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.model

data class Review(
    val contents: String,
    val reviewId: Int,
    val starRating: Int,
    val storeId: Int,
    val storeImgUrl: Any,
    val storeName: String,
    val time: String
)