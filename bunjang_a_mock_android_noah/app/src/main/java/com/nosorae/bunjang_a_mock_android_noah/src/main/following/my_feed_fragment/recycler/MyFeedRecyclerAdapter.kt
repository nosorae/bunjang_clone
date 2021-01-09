package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.recycler_view.RecentlyViewItemRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.recycler_view.RecentlyViewRecyclerHolder



class MyFeedRecyclerAdapter(private val context: Context?, val itemList: ArrayList<GetMyFeedResult>)
    : RecyclerView.Adapter<MyFeedRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFeedRecyclerHolder {
        return MyFeedRecyclerHolder(context!!,
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_my_feed, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyFeedRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}