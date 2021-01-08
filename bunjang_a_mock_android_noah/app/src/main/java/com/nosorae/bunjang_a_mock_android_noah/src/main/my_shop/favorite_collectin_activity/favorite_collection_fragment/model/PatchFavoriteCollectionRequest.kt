package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model

import com.google.gson.annotations.SerializedName


data class PatchFavoriteCollectionRequest(
        @SerializedName("name") val name: String
)