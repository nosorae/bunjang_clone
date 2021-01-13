package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityFavoriteCollectionItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model.FavoriteCollectionItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model.FavoriteCollectionItemResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.recycler_view.FavoriteCollectionRecyclerAdapter

class FavoriteCollectionItemActivity : BaseActivity<ActivityFavoriteCollectionItemBinding>(ActivityFavoriteCollectionItemBinding::inflate),
                                       FavoriteCollectionItemActivityView{
    private var recyclerItemList = ArrayList<FavoriteCollectionItemResult>()
    private lateinit var recyclerAdapter : FavoriteCollectionRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //받아온 컬렉션 타이틀 적어줌
        val title = intent.getStringExtra("title")
        val collectionId = intent.getIntExtra("collectionId", 1)
        binding.favoriteCollectionTextViewTitle.text = title


        showLoadingDialog(this)
        FavoriteCollectionItemService(this).tryGetCollectionItem(collectionId ,'Y')

        binding.favoriteCollectionItemButtonBack.setOnClickListener {
            finish()
        }

        binding.favoriteCollectionItemSelling.setOnClickListener {
            binding.favoriteCollectionItemSelling.setTextColor(Color.BLACK)
            binding.favoriteCollectionItemSelled.setTextColor(Color.LTGRAY)
            binding.favoriteCollectionItemSelledLine.visibility = View.INVISIBLE
            binding.favoriteCollectionItemSellingLine.visibility =View.VISIBLE
            FavoriteCollectionItemService(this).tryGetCollectionItem(collectionId ,'Y')
        }
        binding.favoriteCollectionItemSelled.setOnClickListener {
            binding.favoriteCollectionItemSelled.setTextColor(Color.BLACK)
            binding.favoriteCollectionItemSelling.setTextColor(Color.LTGRAY)
            binding.favoriteCollectionItemSelledLine.visibility = View.VISIBLE
            binding.favoriteCollectionItemSellingLine.visibility =View.INVISIBLE
            FavoriteCollectionItemService(this).tryGetCollectionItem(collectionId ,'N')
        }






    }


    override fun onGetCollectionItemSuccess(itemResponse: FavoriteCollectionItemResponse) {

        dismissLoadingDialog()

        if(itemResponse.result.size > 0) {
            binding.favoriteCollectionItemRecyclerView.visibility = View.VISIBLE
            binding.favoriteCollectionItemNonContainer.visibility = View.INVISIBLE
            recyclerItemList = itemResponse.result as ArrayList<FavoriteCollectionItemResult>
            recyclerAdapter = FavoriteCollectionRecyclerAdapter(this, recyclerItemList)
            binding.favoriteCollectionItemRecyclerView.apply {
                adapter = recyclerAdapter
                layoutManager = GridLayoutManager(context, 2)
            }
        } else {
            binding.favoriteCollectionItemRecyclerView.visibility = View.INVISIBLE
            binding.favoriteCollectionItemNonContainer.visibility = View.VISIBLE
        }


    }

    override fun onGetCollectionItemFailure(message: String) {
        dismissLoadingDialog()
    }
}