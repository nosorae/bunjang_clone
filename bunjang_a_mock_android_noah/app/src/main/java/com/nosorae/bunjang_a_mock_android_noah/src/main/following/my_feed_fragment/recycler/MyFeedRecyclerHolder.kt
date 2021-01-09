package com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.recycler

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResult



class MyFeedRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val itemImgId = itemView.findViewById<ImageView>(R.id.recycler_my_feed_item_image)
    val itemNameId = itemView.findViewById<TextView>(R.id.recycler_my_feed_item_name)
    val priceId = itemView.findViewById<TextView>(R.id.recycler_my_feed_price)
    val sellerImgId = itemView.findViewById<ImageView>(R.id.recycler_my_feed_seller_image)
    val sellerNmaeId = itemView.findViewById<TextView>(R.id.recycler_my_feed_seller_name)




    val context = context
    fun bindView(item : GetMyFeedResult) {

        Glide.with(context).load(item.productImgUrl).into(itemImgId)
        if(item.price != null){
            priceId.text = item.price.toString()
        }

        itemNameId.text = item.productName

        if(item.storeImgUrl != null) {
            Glide.with(context).load(item.storeImgUrl).into(sellerImgId)
        }

        sellerNmaeId.text = item.storeName






    }
}