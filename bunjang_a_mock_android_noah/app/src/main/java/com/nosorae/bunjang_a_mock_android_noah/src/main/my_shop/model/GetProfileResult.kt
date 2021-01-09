package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model

data class GetProfileResult(
        val storeImgUrl: Any,
        val storeName: String,
        val starRatinvAvg: Double?,
        val pickCount: Int,
        val reviewCount: Int,
        val followerCount: Int,
        val followingCount: Int
)