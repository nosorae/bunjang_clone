package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyShopBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentSellingBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.AddItemActivityView
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.AddItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model.UpdateItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.recycler_view.BungaeTalkRecyclerViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.my_feed_fragment.model.GetMyFeedResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopService
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.DeleteItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.recycler_view.MySellingRecyclerAdapter


class SellingFragment(val forCallback: MyShopFragmentView) :
        BaseFragment<FragmentSellingBinding>(FragmentSellingBinding::bind, R.layout.fragment_selling),
        SellingFragmentView, MyShopFragmentView, AddItemActivityView {

    var isFirst = true

    var isDefault = true
    private var recyclerItemList = ArrayList<GetMySellingResult>()
    private var isInList = ArrayList<GetMySellingResult>()
    private lateinit var recyclerAdapter : MySellingRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(isFirst) {
            showLoadingDialog(context!!)
            SellingService(this).tryGetSelling('Y')
        }



        binding.myShopSellingButtonUpdate.setOnClickListener {
            if(isDefault) {
                isInList =  ArrayList<GetMySellingResult>()
                recyclerAdapter = MySellingRecyclerAdapter(context, recyclerItemList, 1, this, isInList)
                binding.myShopSellingRecycler.apply {
                    adapter = recyclerAdapter
                    layoutManager = LinearLayoutManager(context)
                }

                binding.myShopSellingButtonUpdate.setImageResource(R.drawable.my_shop_close)

                forCallback.onClickUpdateButton(1)


                isDefault = false
            } else {
                showLoadingDialog(context!!)
                SellingService(this).tryGetSelling('Y')
                binding.myShopSellingButtonUpdate.setImageResource(R.drawable.global_pencil)
                forCallback.onClickUpdateButton(0)
                isDefault = true
            }

        }

    }


    override fun onGetSellingSeccess(response: GetMySellingResponse) {
        dismissLoadingDialog()

            recyclerItemList = response.result as ArrayList<GetMySellingResult>
            if(recyclerItemList.size == 0) {
                binding.mySellingFragmentContainer.visibility = View.INVISIBLE
            } else {
                recyclerAdapter = MySellingRecyclerAdapter(context, recyclerItemList, 0, this, isInList)
                binding.myShopSellingRecycler.apply {
                    adapter = recyclerAdapter
                    layoutManager = LinearLayoutManager(context)
                }
            }




    }

    override fun onGetSellingFailure(messge: String?) {

    }
    // isInList를 MyShopFragment에 넘겨줘서 삭제시키고 ui도 업데이트
    override fun onClickCheck(isOn: Int) {
        forCallback.onClickCheckLast(isOn, isInList, this)



    }

    override fun onClickdelete(isInList: ArrayList<GetMySellingResult>) {
        TODO("Not yet implemented")
    }

    //-------------------------------------------------마이샵뷰
    override fun onGetProfileSeccess(response: GetProfileResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetProfileFailure(messge: String?) {
        TODO("Not yet implemented")
    }

    override fun onDeleteItemSeccess(response: DeleteItemResponse) {
        TODO("Not yet implemented")
    }

    override fun onDeleteItemFailure(messge: String?) {
        TODO("Not yet implemented")
    }

    override fun onClickCheckLast(isOn: Int, isInList: ArrayList<GetMySellingResult>, forCallback: MyShopFragmentView) {
        TODO("Not yet implemented")
    }

    override fun onClickUpdateButton(isOn: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickDeleteButton() {
        for(obj in isInList){
            recyclerItemList.remove(obj)
        }
        isInList =  ArrayList<GetMySellingResult>()
        recyclerAdapter = MySellingRecyclerAdapter(context, recyclerItemList, 1, this, isInList)
        binding.myShopSellingRecycler.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)
        }

        showLoadingDialog(context!!)
        SellingService(this).tryGetSelling('Y')
        binding.myShopSellingButtonUpdate.setImageResource(R.drawable.global_pencil)
        forCallback.onClickUpdateButton(0)
        isDefault = true

    }
    //-------------------------------AddItemView---------------------------

    override fun onPostAddItemSuccess(response: AddItemResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostAddItemFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPutUpdateItemSuccess(response: UpdateItemResponse) {
        showLoadingDialog(context!!)
        SellingService(this).tryGetSelling('Y')
    }

    override fun onPutUpdateItemFailure(message: String) {

    }


    override fun onStart() {
        super.onStart()
        if(!isFirst) {
            showLoadingDialog(context!!)
            SellingService(this).tryGetSelling('Y')
        }

    }

    override fun onPause() {
        super.onPause()
        isFirst = false
    }
}