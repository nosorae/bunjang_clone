package com.nosorae.bunjang_a_mock_android_noah.src.main.home.model

import com.google.gson.annotations.SerializedName

data class PostFavoriteRequest(
        @SerializedName("collectionId") val collectionId: Int?
)