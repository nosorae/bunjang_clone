package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model

data class GetInnerResult(
        val followerCount: Int,
        val productCount: Int,
        val products: List<GetInnerProduct>,
        val storeId: Int,
        val storeImgUrl: Any,
        val storeName: String
)