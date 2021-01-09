package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model

data class FavoriteCollectionItemResult(
    val pickId: Int,
    val productId: Int,
    val productName: String,
    val price: Int?,
    val storeId: Int,
    val storeImgUrl: String?,
    val storeName: String,
    val productImgUrl: String,
    val time: String,
    val isPick: Int
)