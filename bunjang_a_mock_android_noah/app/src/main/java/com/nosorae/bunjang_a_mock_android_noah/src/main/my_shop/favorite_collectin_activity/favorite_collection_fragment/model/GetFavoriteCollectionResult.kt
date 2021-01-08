package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model

data class GetFavoriteCollectionResult(
    val collectionId: Int,
    var collectionName: String,
    val lastPickImg: String?,
    val pickCount: Int
)