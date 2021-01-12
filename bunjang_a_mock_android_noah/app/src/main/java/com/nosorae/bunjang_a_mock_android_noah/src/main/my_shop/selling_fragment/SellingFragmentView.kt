package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult

interface SellingFragmentView {
    fun onGetSellingSeccess(response: GetMySellingResponse)
    fun onGetSellingFailure(messge: String?)

    fun onClickCheck(isOn: Int)

    fun onClickdelete(isInList: ArrayList<GetMySellingResult>)

}



