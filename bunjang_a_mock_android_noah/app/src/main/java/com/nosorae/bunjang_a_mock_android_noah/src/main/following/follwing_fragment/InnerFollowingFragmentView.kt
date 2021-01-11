package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model.GetInnerResponse

interface InnerFollowingFragmentView {

    fun onGetInnerSuccess(response: GetInnerResponse)
    fun onGetInnerFailure(message: String)
}