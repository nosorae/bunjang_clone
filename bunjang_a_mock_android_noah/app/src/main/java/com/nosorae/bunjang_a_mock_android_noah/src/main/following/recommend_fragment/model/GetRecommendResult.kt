package com.nosorae.bunjang_a_mock_android_noah.src.main.following.recommend_fragment.model

data class GetRecommendResult(
    val followerCount: Int,
    val productCount: Int,
    val products: List<Product>,
    val storeId: Int,
    val storeImgUrl: String,
    val storeName: String
)