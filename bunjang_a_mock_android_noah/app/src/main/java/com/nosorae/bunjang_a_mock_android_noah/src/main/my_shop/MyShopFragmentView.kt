package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.DeleteItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult

interface MyShopFragmentView {
    fun onGetProfileSeccess(response: GetProfileResponse)
    fun onGetProfileFailure(messge: String?)

    fun onDeleteItemSeccess(response: DeleteItemResponse)
    fun onDeleteItemFailure(messge: String?)

    fun onClickDeleteButton()



    fun onClickCheckLast(isOn: Int, isInList: ArrayList<GetMySellingResult>, forCallback: MyShopFragmentView)
    fun onClickUpdateButton(isOn: Int)
}