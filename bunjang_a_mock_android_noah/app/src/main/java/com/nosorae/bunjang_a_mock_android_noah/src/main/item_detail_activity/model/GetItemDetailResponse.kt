package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model

data class GetItemDetailResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: GetItemDetailResult
)