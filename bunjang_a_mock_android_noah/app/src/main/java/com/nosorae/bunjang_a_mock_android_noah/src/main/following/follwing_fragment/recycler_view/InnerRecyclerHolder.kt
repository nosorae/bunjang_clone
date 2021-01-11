package com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.recycler_view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.follwing_fragment.model.GetInnerResult


class InnerRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val sellerImgId = itemView.findViewById<ImageView>(R.id.recycler_inner_following_profile_image)
    val sellerNameId = itemView.findViewById<TextView>(R.id.recycler_inner_following_profile_name)
    val numOfItemId = itemView.findViewById<TextView>(R.id.recycler_inner_following_num_of_selling)
    val numOfFollowerId = itemView.findViewById<TextView>(R.id.recycler_inner_following_num_of_follower)
    val imageId1 = itemView.findViewById<ImageView>(R.id.recycler_inner_following_image1)
    val imageId2 = itemView.findViewById<ImageView>(R.id.recycler_inner_following_image2)
    val imageId3 = itemView.findViewById<ImageView>(R.id.recycler_inner_following_image3)
    val priceId1 = itemView.findViewById<TextView>(R.id.recycler_inner_following_price1)
    val priceId2 = itemView.findViewById<TextView>(R.id.recycler_inner_following_price2)
    val priceId3 = itemView.findViewById<TextView>(R.id.recycler_inner_following_price3)




    val context = context

    fun bindView(item : GetInnerResult) {
        if(item.storeImgUrl != null) {
            Glide.with(context).load(item.storeImgUrl).into(sellerImgId)
        }
        sellerNameId.text = item.storeName
        numOfItemId.text = item.productCount.toString()
        numOfFollowerId.text = item.followerCount.toString()

        when(item.products.size) {
            1 -> {
                Glide.with(context).load(item.products[0].productImgUrl).into(imageId1)
                priceId1.text = parseToMoney(item.products[0].price.toString())+" 원"
                priceId2.visibility=View.GONE
                imageId2.visibility=View.GONE
                priceId3.visibility=View.GONE
                imageId3.visibility=View.GONE
            }
            2 -> {
                Glide.with(context).load(item.products[0].productImgUrl).into(imageId1)
                priceId1.text = parseToMoney(item.products[0].price.toString())+" 원"
                Glide.with(context).load(item.products[1].productImgUrl).into(imageId2)
                priceId2.text = parseToMoney(item.products[1].price.toString())+" 원"
                priceId3.visibility=View.GONE
                imageId3.visibility=View.GONE
            }
            3-> {
                Glide.with(context).load(item.products[0].productImgUrl).into(imageId1)
                priceId1.text = parseToMoney(item.products[0].price.toString())+" 원"
                Glide.with(context).load(item.products[1].productImgUrl).into(imageId2)
                priceId2.text = parseToMoney(item.products[1].price.toString())+" 원"
                Glide.with(context).load(item.products[2].productImgUrl).into(imageId3)
                priceId3.text = parseToMoney(item.products[2].price.toString())+" 원"

            }
        }



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