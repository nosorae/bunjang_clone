package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model

data class GetFavoriteCollectionResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<GetFavoriteCollectionResult>
)