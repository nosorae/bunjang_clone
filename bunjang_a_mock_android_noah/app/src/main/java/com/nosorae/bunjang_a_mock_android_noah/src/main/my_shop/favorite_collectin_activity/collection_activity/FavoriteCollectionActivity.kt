package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_activity

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityFavoriteCollectionItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_activity.model.FavoriteCollectionResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_activity.recycler_view.FavoriteCollectionRecyclerViewAdapter

class FavoriteCollectionActivity : BaseActivity<ActivityFavoriteCollectionItemBinding>(ActivityFavoriteCollectionItemBinding::inflate) {
    private var recyclerItemList = ArrayList<FavoriteCollectionResult>()
    private lateinit var recyclerAdapter : FavoriteCollectionRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra("title")
        binding.favoriteCollectionTextViewTitle.text = title

        for(i in 1..10){
            recyclerItemList.add(
                FavoriteCollectionResult(
                1, 1, "무스너클 개비싸", 9999999, 1
            ,"https://t1.daumcdn.net/cfile/tistory/994BEF355CD0313D05?download"
                ,"창렬상점"
                ,"https://t1.daumcdn.net/cfile/tistory/994BEF355CD0313D05?download"
                ,"5", 1
            )
            )
        }

        recyclerAdapter = FavoriteCollectionRecyclerViewAdapter(this, recyclerItemList)
        binding.favoriteCollectionRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
        }

    }
}