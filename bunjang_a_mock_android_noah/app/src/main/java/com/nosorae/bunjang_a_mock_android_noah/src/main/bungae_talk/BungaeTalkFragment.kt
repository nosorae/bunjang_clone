package com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentBungaeTalkBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.collection_activity.model.FavoriteCollectionResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_item_activity.collection_activity.recycler_view.FavoriteCollectionRecyclerViewAdapter


class BungaeTalkFragment :
    BaseFragment<FragmentBungaeTalkBinding>(FragmentBungaeTalkBinding::bind, R.layout.fragment_bungae_talk) {


    private var recyclerItemList = ArrayList<BungaeTalkRecyclerViewItem>()
    private lateinit var recyclerAdapter : BungaeTalkRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 1..10) {
            recyclerItemList.add(BungaeTalkRecyclerViewItem(
                "https://t1.daumcdn.net/cfile/tistory/994BEF355CD0313D05?download",
                "이름",
                "최근 대화",
                "오후 9:30",
                3
            ))
        }

        recyclerAdapter = BungaeTalkRecyclerViewAdapter(context, recyclerItemList)
        binding.bungaeTalkRecyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }
}