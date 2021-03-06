package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.recycler_view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.collection_item_activity.model.FavoriteCollectionItemResult



class FavoriteCollectionRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val productName = itemView.findViewById<TextView>(R.id.collectin_item_product_name)
    val priceId = itemView.findViewById<TextView>(R.id.collection_item_price)
    val sellerImgId = itemView.findViewById<ImageView>(R.id.collection_item_seller_image)
    val itemImgId = itemView.findViewById<ImageView>(R.id.home_item_image_item_image)
    val sellerNameId = itemView.findViewById<TextView>(R.id.collection_item_seller_name)
    val dayId = itemView.findViewById<TextView>(R.id.collection_item_day)
    val context = context

    fun bindView(item : FavoriteCollectionItemResult) {
        if(item.storeImgUrl != null) {
            Glide.with(context).load(item.storeImgUrl).into(sellerImgId)
        } else {
            sellerImgId.setImageResource(R.drawable.no_profile_image)
        }

        Glide.with(context).load(item.productImgUrl).into(itemImgId)

        productName.text = item.productName
        if(item.price != null) {
            priceId.text = parseToMoney(item.price.toString())
        }


        sellerNameId.text = item.storeName
        dayId.text = item.time

    }

    fun parseToMoney(str: String): String {
        var len = str.length
        var arr = str.toCharArray()
        var sb = StringBuilder()
        var before = str
        var cur = str
        if(len > 0) {
            var cnt = 1
            var idx = len-1
            while(cnt <= len){
                sb.append(arr[idx])
                if(cnt%3 == 0 ) {
                    if(cnt != len) {
                        sb.append(',')
                    }
                }
                cnt+=1
                idx-=1

            }
        }
        return sb.reverse().toString()
    }
}