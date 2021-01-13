package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_selling_item

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.Sale


class SellingRcyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imgId = itemView.findViewById<ImageView>(R.id.recycler_selling_image)
    val priceId = itemView.findViewById<TextView>(R.id.recycler_selling_price)
    val wonId =itemView.findViewById<TextView>(R.id.recycler_selling_price_won)


    val context = context
    fun bindView(item : Sale) {

        Glide.with(context).load(item.productImgUrl).into(imgId)
        if(item.price != null) {
            priceId.text = parseToMoney(item.price.toString())
            wonId.text = "원"
        }

        wonId.text = ""





    }

    public fun parseToMoney(str: String): String {
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