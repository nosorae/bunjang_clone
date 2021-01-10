package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model

data class OneCategoryResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<OneCategoryResult>
)