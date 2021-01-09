package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.log_in.model.KakaoSignUpResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse

interface MyFeedFragmentView {

    fun onGetMyFeedSuccess(response: GetMyFeedResponse)
    fun onGetMyFeedFailure(message: String)
}