package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.recycler_view


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R

class RecentlyViewRecyclerAdapter(private val context: Context?, val itemList: ArrayList<RecentlyViewItemRecyclerViewItem>)
    : RecyclerView.Adapter<RecentlyViewRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewRecyclerHolder {
        return RecentlyViewRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_recently_veiw, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecentlyViewRecyclerHolder, position: Int) {
        holder.bindView(itemList[position])
    }
}