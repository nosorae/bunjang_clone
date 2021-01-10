package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity

import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResponse

interface OneCategoryActivityView {

    fun onGetItemSuccess(response: OneCategoryResponse)
    fun onGetItemFailure(message: String)
}