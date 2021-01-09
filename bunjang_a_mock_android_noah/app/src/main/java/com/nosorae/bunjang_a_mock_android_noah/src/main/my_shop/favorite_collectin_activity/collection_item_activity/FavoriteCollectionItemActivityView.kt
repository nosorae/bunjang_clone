package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model.FavoriteCollectionItemResponse

interface FavoriteCollectionItemActivityView {

    fun onGetCollectionItemSuccess(itemResponse: FavoriteCollectionItemResponse)
    fun onGetCollectionItemFailure(message: String)
}