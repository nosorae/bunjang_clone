package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity


import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse


interface ItemDetailActivityView {

    fun onGetItemDetailSignUpSuccess(response: GetItemDetailResponse)
    fun onGetItemDetailSignUpFailure(message: String)
}