package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment

import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.DeleteFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.GetFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.PatchFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.PostFavoriteCollectionResponse

interface FavoriteCollectionFragmentView {

    fun onGetCollectionSuccess(response: GetFavoriteCollectionResponse)
    fun onGetCollectionFailure(message: String)

    fun onPostCollectionSuccess(response: PostFavoriteCollectionResponse)
    fun onPostCollectionFailure(message: String)

    fun onDeleteCollectionSuccess(response: DeleteFavoriteCollectionResponse)
    fun onDeleteCollectionFailure(message: String)

    fun onPatchCollectionSuccess(response: PatchFavoriteCollectionResponse)
    fun onPatchCollectionFailure(message: String)

    fun onAddCollectionDialog(name: String)
    fun onChangeCollectionDialog(name: String)
}