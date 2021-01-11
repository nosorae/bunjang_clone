package com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_item_recylcer

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.one_category_recycler.OneCategoryRecyclerItem


class OneItemRecyclerHolder(context: Context, itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val imgId = itemView.findViewById<ImageView>(R.id.recycler_category_item_image)
    val priceId = itemView.findViewById<TextView>(R.id.recycler_category_item_price)
    val nameId = itemView.findViewById<TextView>(R.id.recycler_category_item_name)

    val context = context

    fun bindView(item : OneCategoryResult) {
        Glide.with(context).load(item.productImgUrl).into(imgId)
        priceId.text = parseToMoney(item.price.toString())
        nameId.text = item.productName
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