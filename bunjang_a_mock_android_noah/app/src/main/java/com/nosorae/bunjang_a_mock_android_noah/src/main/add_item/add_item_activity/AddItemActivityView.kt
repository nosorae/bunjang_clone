package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity

import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.UpdateItemResponse

interface AddItemActivityView {
    fun onPostAddItemSuccess(response: AddItemResponse)
    fun onPostAddItemFailure(message: String)

    fun onPutUpdateItemSuccess(response: UpdateItemResponse)
    fun onPutUpdateItemFailure(message: String)
}