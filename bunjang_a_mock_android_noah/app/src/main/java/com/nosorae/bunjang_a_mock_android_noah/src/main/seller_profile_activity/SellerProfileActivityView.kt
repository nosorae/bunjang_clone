package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.model.GetSellerProfileResponse

interface SellerProfileActivityView {

    fun onGetSellerProfileSeccess(response: GetSellerProfileResponse)
    fun onGetSellerProfileFailure(messge: String?)
}