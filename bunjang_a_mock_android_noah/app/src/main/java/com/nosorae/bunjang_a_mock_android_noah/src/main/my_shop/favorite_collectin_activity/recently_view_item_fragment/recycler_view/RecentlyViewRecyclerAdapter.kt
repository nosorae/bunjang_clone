package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.recycler_view


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.RecentlyViewItem

class RecentlyViewRecyclerAdapter(private val context: Context?, val itemList: ArrayList<RecentlyViewItem>)
    : RecyclerView.Adapter<RecentlyViewRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewRecyclerHolder {
        return RecentlyViewRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_recently_veiw, parent, false))

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecentlyViewRecyclerHolder, position: Int) {
        val container = holder.itemView.findViewById<ConstraintLayout>(R.id.recently_view_item_container)
        container.setOnClickListener {
            val intent = Intent(context, ItemDetailActivity::class.java)
            intent.putExtra("itemId", itemList[position].productId)
            context!!.startActivity(intent)
        }
        holder.bindView(itemList[position])
    }
}