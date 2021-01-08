package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse

interface MyShopFragmentView {
    fun onGetProfileSeccess(response: GetProfileResponse)
    fun onGetProfileFailure(messge: String?)
}