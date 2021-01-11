package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model

data class GetMySellingResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<GetMySellingResult>
)