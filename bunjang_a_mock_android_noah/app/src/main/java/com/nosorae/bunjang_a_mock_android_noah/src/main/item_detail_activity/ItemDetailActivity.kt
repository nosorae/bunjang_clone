package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityItemDetailBinding
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.dialog.LogInDialog
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager.ItemDetailPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager.ItemDetailPagerItem

class ItemDetailActivity
    : BaseActivity<ActivityItemDetailBinding>(ActivityItemDetailBinding::inflate) ,
      ItemDetailActivityView {

    private var pageItemList = ArrayList<ItemDetailPagerItem>()
    private lateinit var myAdapter : ItemDetailPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.activityItemDetailScrollView.setOnScrollChangeListener { view, i, i2, i3, i4 ->

        }

        pageItemList.add(ItemDetailPagerItem(R.drawable.metwo))
        pageItemList.add(ItemDetailPagerItem(R.drawable.metwo))
        pageItemList.add(ItemDetailPagerItem(R.drawable.metwo))
        myAdapter = ItemDetailPagerAdapter(this, pageItemList)
        var viewPager = binding.itemDeatilViewPager.apply {
            adapter = myAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        var tabLayout = binding.itemDetailTabLayout

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
        }.attach()

        val itemId = intent.getIntExtra("itemId", 1)

        ItemDetailService(this).tryGetItemDetail(itemId)







    }


    override fun onGetItemDetailSignUpSuccess(response: GetItemDetailResponse) {
        binding.itemDetailName.text = response.result.info.productName
    }

    override fun onGetItemDetailSignUpFailure(message: String) {
        TODO("Not yet implemented")
    }
}