package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.recycler_view


import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.RecentlyViewItem

class RecentlyViewRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imageId = itemView.findViewById<ImageView>(R.id.recently_view_item_image)
    val nameId = itemView.findViewById<TextView>(R.id.recently_view_item_text_name)
    val priceId = itemView.findViewById<TextView>(R.id.recently_view_item_text_price)



    val context = context
    fun bindView(item : RecentlyViewItem) {

        Glide.with(context).load(item.imgUrl).into(imageId)
        nameId.text = item.name
        priceId.text = item.price.toString()


    }
}