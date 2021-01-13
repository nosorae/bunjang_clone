package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentRecentlyViewItemBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailActivityView
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.ItemDetailService
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.PostFollowResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.RecentlyViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.recycler_view.RecentlyViewItemRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.recently_view_item_fragment.recycler_view.RecentlyViewRecyclerAdapter
import java.lang.reflect.Type

class RecentlyViewItemFragment :
        BaseFragment<FragmentRecentlyViewItemBinding>(FragmentRecentlyViewItemBinding::bind, R.layout.fragment_recently_view_item),
        ItemDetailActivityView {

    private var recyclerItemList = ArrayList<RecentlyViewItem>()
    private lateinit var recyclerItemRecyclerAdapter : RecentlyViewRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentMyShopNum.text = "0"
        val temp = getArrayList("recently")
        if(temp != null) {
            for(obj in temp) {
                recyclerItemList.add(obj)
            }
        }
        var temp2 = ArrayList<RecentlyViewItem>()
        recyclerItemList.reverse()

        for(obj in recyclerItemList) {
            if(!temp2.contains(obj)){
                temp2.add(obj)
            }
        }
        recyclerItemList = ArrayList<RecentlyViewItem>()

        for(obj in temp2) {
            ItemDetailService(this).tryGetItemDetail(obj.productId)
        }





        binding.fragmentMyShopNum.text = recyclerItemList.size.toString()

        recyclerItemRecyclerAdapter =RecentlyViewRecyclerAdapter(context, recyclerItemList)
        binding.recentlyViewRecyclerView.apply {
            adapter = recyclerItemRecyclerAdapter
            layoutManager = GridLayoutManager(context, 2)
            //addItemDecoration(RecentlyViewItemRecyclerViewSpacing(2, 2))
        }



    }

    override fun onGetItemDetailSignUpSuccess(response: GetItemDetailResponse) {
        Log.d("itemDetail", response.message)
        if(response.code == 1000) {
            recyclerItemList.add(RecentlyViewItem(response.result.info.productId,
            response.result.info.productName,
            response.result.info.price,
            response.result.productImg[0].imgUrl))
            recyclerItemRecyclerAdapter.notifyDataSetChanged()
            binding.fragmentMyShopNum.text =  (binding.fragmentMyShopNum.text.toString().toInt()+1).toString()
        }
    }

    override fun onGetItemDetailSignUpFailure(message: String) {
        Log.d("itemDetail", message)
    }

    override fun onPostFollowSuccess(response: PostFollowResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostFollowFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onClickAgreePush() {
        TODO("Not yet implemented")
    }

    //----------------------------------------------------------------------------------------------
    fun saveArrayList(list: java.util.ArrayList<RecentlyViewItem>?, key: String?) {
        val prefs = context!!.getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply() // This line is IMPORTANT !!!
    }

    fun getArrayList(key: String?): java.util.ArrayList<RecentlyViewItem>? {
        val prefs = context!!.getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type = object : TypeToken<java.util.ArrayList<RecentlyViewItem?>?>() {}.getType()
        return gson.fromJson(json, type)
    }


}