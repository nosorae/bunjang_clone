package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.model

data class GetSellerProfileResult(
    val info: Info,
    val productList: List<Product>,
    val reviewList: List<Review>
)