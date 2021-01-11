package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment

import android.os.Bundle
import android.util.Log

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentFavoriteCollectionBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.add_collection_dialog.AddCollectionDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.*
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.ordering_dialog.OrderingDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.recycler_view.FavoriteItemRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.recycler_view.FavoriteItemRecyclerViewSpacing

class FavoriteCollectionFragment :
    BaseFragment<FragmentFavoriteCollectionBinding>(FragmentFavoriteCollectionBinding::bind, R.layout.fragment_favorite_collection),
    FavoriteCollectionFragmentView {

    private var recyclerItemList = ArrayList<GetFavoriteCollectionResult>()
    private lateinit var recyclerAdapter : FavoriteItemRecyclerViewAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        showLoadingDialog(context!!)
        FavoriteCollectionService(this).tryGetCollection()





        binding.favoriteCollectionFragmentButtonAdd.setOnClickListener {
            AddCollectionDialog(context!!, this, 0, 0, "").showLogInDialog()
        }
        binding.favoriteCollectionFragmentButtonOrdering.setOnClickListener {
            OrderingDialog(context!!).showLogInDialog()
        }


    }


    override fun onGetCollectionSuccess(response: GetFavoriteCollectionResponse) {
        dismissLoadingDialog()
        recyclerItemList =  response.result as ArrayList<GetFavoriteCollectionResult>

        recyclerAdapter = FavoriteItemRecyclerViewAdapter(context, recyclerItemList)
        binding.favoriteRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(FavoriteItemRecyclerViewSpacing(2, 2))
        }


    }

    override fun onGetCollectionFailure(message: String) {
        dismissLoadingDialog()
    }

    override fun onPostCollectionSuccess(response: PostFavoriteCollectionResponse) {
        Log.d("collection", response.message)
    }

    override fun onPostCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onAddCollectionDialog(name: String) {
        recyclerItemList.add(GetFavoriteCollectionResult(1, name, null, 0))
        recyclerAdapter.notifyDataSetChanged()

        FavoriteCollectionService(this).tryPostCollection(name)

    }

    override fun onDeleteCollectionSuccess(response: DeleteFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onDeleteCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPatchCollectionSuccess(response: PatchFavoriteCollectionResponse) {


    }

    override fun onPatchCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onChangeCollectionDialog(name: String) {
        TODO("Not yet implemented")
    }
}