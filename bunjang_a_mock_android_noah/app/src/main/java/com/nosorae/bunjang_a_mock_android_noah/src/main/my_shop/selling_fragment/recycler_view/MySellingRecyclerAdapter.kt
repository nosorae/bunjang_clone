package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.recycler_view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.item_more_dialog.ItemMoreDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.SellingFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult


class MySellingRecyclerAdapter(private val context: Context?, val itemList: ArrayList<GetMySellingResult>,
                               val isUpdate: Int,
                               val forCallBack: SellingFragmentView,
                               val isInList: ArrayList<GetMySellingResult>)
    : RecyclerView.Adapter<MySellingRecyclerHolder>(), SellingFragmentView {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySellingRecyclerHolder {

        if(isUpdate == 0) {
            return MySellingRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_my_selling, parent, false), isUpdate)
        } else {
            return MySellingRecyclerHolder(context!!,
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_my_selling_update, parent, false), isUpdate)
        }


    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MySellingRecyclerHolder, position: Int) {
        val container = holder.itemView.findViewById<ConstraintLayout>(R.id.recycler_my_selling_conatiner)
        container.setOnClickListener {
            if(isUpdate == 0) {
                val more = holder.itemView.findViewById<ImageView>(R.id.recycler_my_selling_product_more)
                more.setOnClickListener {
                    ItemMoreDialog(context!!, this, itemList[position].productId).showLogInDialog()
                }

                val intent = Intent(context, ItemDetailActivity::class.java)
                intent.putExtra("itemId", itemList[position].productId)
                context!!.startActivity(intent)
            } else {

                    val updateId = holder.itemView.findViewById<ImageView>(R.id.recycler_my_selling_product_update)
                    if(isInList.contains(itemList[position])) {
                        updateId.background = ContextCompat.getDrawable(context!!, R.drawable.my_selling_update_check_background_gray)
                        isInList.remove(itemList[position])
                    } else {

                        updateId.background = ContextCompat.getDrawable(context!!, R.drawable.my_selling_update_check_background_red)
                        isInList.add(itemList[position])
                    }
                    if(isInList.size > 0){
                        forCallBack.onClickCheck(1)
                    } else {
                        forCallBack.onClickCheck(0)
                    }


        }
        if(isUpdate == 0) {
            val moreId =  holder.itemView.findViewById<ImageView>(R.id.recycler_my_selling_product_more)
        } else {


            }
        }


        holder.bindView(itemList[position])
    }

    override fun onGetSellingSeccess(response: GetMySellingResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetSellingFailure(messge: String?) {
        TODO("Not yet implemented")
    }

    override fun onClickCheck(isOn: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickdelete(isInList: ArrayList<GetMySellingResult>) {
        TODO("Not yet implemented")
    }
}