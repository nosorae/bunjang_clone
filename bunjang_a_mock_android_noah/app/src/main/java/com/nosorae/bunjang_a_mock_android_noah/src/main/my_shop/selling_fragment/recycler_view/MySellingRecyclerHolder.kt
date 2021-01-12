package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.recycler_view

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult

class MySellingRecyclerHolder(context: Context, itemView: View, val isUpdate: Int)
    : RecyclerView.ViewHolder(itemView) {

    val imgId = itemView.findViewById<ImageView>(R.id.recycler_my_selling_product_image)
    val nameId = itemView.findViewById<TextView>(R.id.recycler_my_selling_product_name)
    val priceId = itemView.findViewById<TextView>(R.id.recycler_my_selling_product_price)

    val imgIdU = itemView.findViewById<ImageView>(R.id.recycler_my_selling_product_image_u)
    val nameIdU = itemView.findViewById<TextView>(R.id.recycler_my_selling_product_name_u)
    val priceIdU = itemView.findViewById<TextView>(R.id.recycler_my_selling_product_price_u)




    val context = context

    fun bindView(item : GetMySellingResult) {
        if(isUpdate == 0) {
            Glide.with(context).load(item.productImgUrl).into(imgId)
            nameId.text = item.productName
            priceId.text = parseToMoney(item.price.toString())
        } else {
            Glide.with(context).load(item.productImgUrl).into(imgIdU)
            nameIdU.text = item.productName
            priceIdU.text = parseToMoney(item.price.toString())
        }

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