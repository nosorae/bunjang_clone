package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity


import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.PostFollowResponse


interface ItemDetailActivityView {

    fun onGetItemDetailSignUpSuccess(response: GetItemDetailResponse)
    fun onGetItemDetailSignUpFailure(message: String)

    fun onPostFollowSuccess(response: PostFollowResponse)
    fun onPostFollowFailure(message: String)
}