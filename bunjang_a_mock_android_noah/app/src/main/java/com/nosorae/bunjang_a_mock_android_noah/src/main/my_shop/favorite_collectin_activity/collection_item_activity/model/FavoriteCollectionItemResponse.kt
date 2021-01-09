package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model

data class FavoriteCollectionItemResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<FavoriteCollectionItemResult>
)