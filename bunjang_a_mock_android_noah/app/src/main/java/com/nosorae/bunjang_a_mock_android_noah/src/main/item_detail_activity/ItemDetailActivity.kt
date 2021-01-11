package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityItemDetailBinding
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.dialog.LogInDialog
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.log_in.view_pager.LogInViewPagerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeService
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog.CollectionDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.GetItemResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteRequest
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.PostFavoriteResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.Result
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.CustomCallBack
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.PostFollowResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.Sale
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_selling_item.SellingRcyclerHolder
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_selling_item.SellingRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_selling_item.SellingRecyclerSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager.ItemDetailPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager.ItemDetailPagerItem

class ItemDetailActivity
    : BaseActivity<ActivityItemDetailBinding>(ActivityItemDetailBinding::inflate) ,
      ItemDetailActivityView, HomeFragmentView, CustomCallBack {

    private var pageItemList = ArrayList<ItemDetailPagerItem>()
    private lateinit var myAdapter : ItemDetailPagerAdapter

    private var recyclerSellingList = ArrayList<Sale>()
    private lateinit var recyclerSellingAdapter  : SellingRecyclerAdapter
    var isFollow = false

    var productId = -1
    var check = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.activityItemDetailScrollView.setOnScrollChangeListener { view, i, i2, i3, i4 ->

        }


        binding.itemDetailBack.setOnClickListener {
            finish()
        }








        val itemId = intent.getIntExtra("itemId", 1)


        showLoadingDialog(this)
        ItemDetailService(this).tryGetItemDetail(itemId)







    }


    override fun onGetItemDetailSignUpSuccess(response: GetItemDetailResponse) {

        dismissLoadingDialog()

        productId = response.result.info.productId

        binding.itemDetailName.text = response.result.info.productName
        if(response.result.info.price.toString() != null){
            binding.itemDetailPrice.text = parseToMoney(response.result.info.price.toString())
        }
        binding.itemDetailTime.text = response.result.info.time
        binding.itemDetailNumOfWatch.text = response.result.info.viewCount.toString()
        binding.itemDetailNumOfFavorite.text = response.result.info.pickCount.toString()

        if(response.result.info.area != null) {
            binding.itemDetailLocation.text = response.result.info.area.toString()
        }

        binding.itemDetailTotalNumOfItem.text = "중고 · 배송비별도 · 총"+response.result.info.amount.toString()+"개"

        if(response.result.info.explanation != null) {
            binding.itemDetailDescription.text = response.result.info.explanation
        }

        binding.itemDetailSellerName.text = response.result.info.storeName

        if(response.result.info.storeImgUrl != null){
            Glide.with(this).load(response.result.info.storeImgUrl).into(binding.itemDetailSellerImage)
        } else {
            binding.itemDetailSellerImage.setImageResource(R.drawable.no_profile_image)
        }

        binding.itemDetailNumOfFollower.text = response.result.info.followerCount.toString()

        if(response.result.info.starRatingAvg != null){
            binding.itemDetailRatingBar.rating = response.result.info.starRatingAvg.toFloat()
            binding.itemDetailRatingBar2.rating = response.result.info.starRatingAvg.toFloat()
        }

        //---------------------------------------좋아요---------------------------------------------

        if(response.result.info.isPick == 1) {
            binding.itemDetailUserFavorite.setImageResource(R.drawable.home_favorite_selected)
            binding.itemDetailUserFavorite2.setImageResource(R.drawable.home_favorite_selected)
            check = true
        } else {
            binding.itemDetailUserFavorite.setImageResource(R.drawable.home_favorite_default)
            binding.itemDetailUserFavorite2.setImageResource(R.drawable.global_favorite_black)
            check = false
        }
        binding.itemDetailUserFavorite.setOnClickListener {
            if(check) {
                binding.itemDetailUserFavorite.setImageResource(R.drawable.home_favorite_default)
                binding.itemDetailUserFavorite2.setImageResource(R.drawable.global_favorite_black)
                HomeService(this).tryPostFavorite(productId, PostFavoriteRequest(null))
                check = false
            } else {
                showLoadingDialog(this)
                HomeService(this).tryGetCollection()
            }
        }

        //------------------------------------------------------------------------------------------

        binding.itemDetailTotalNumOfSellingItem.text = response.result.info.productCount.toString()
        binding.itemDetailTotalNumOfReview.text = response.result.info.reviewCount.toString()
        if(response.result.info.reviewCount == 0) {
            binding.itemDetailReviewHeader.visibility = View.GONE
            binding.itemDetailSimilarHeader.visibility = View.GONE
            binding.withSimilar.visibility = View.GONE
        }

        pageItemList = ArrayList<ItemDetailPagerItem>()
        for(obj in response.result.productImg) {
            pageItemList.add(ItemDetailPagerItem(obj.imgUrl))
        }
        myAdapter = ItemDetailPagerAdapter(this, pageItemList)
        var viewPager = binding.itemDeatilViewPager.apply {
            adapter = myAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }


        var tabLayout = binding.itemDetailTabLayout

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
        }.attach()




        //-------------------------------------------------------------------------------------------------
        if(response.result.info.isFollow == 1) {
            binding.itemDetailButtonFollow.setImageResource(R.drawable.button_follow_selected)
        } else {
            binding.itemDetailButtonFollow.setImageResource(R.drawable.button_follow_default)
        }

        binding.itemDetailButtonFollow.setOnClickListener {
            ItemDetailService(this).tryPostFollow(response.result.info.storeId)
        }

        //------------------------------------------------------------------------------------------

        recyclerSellingList = ArrayList<Sale>()
        recyclerSellingList = response.result.saleList as ArrayList<Sale>
        recyclerSellingAdapter = SellingRecyclerAdapter(this, recyclerSellingList)
        binding.itemDetailRecyclerAllItem.apply {
            adapter = recyclerSellingAdapter
            layoutManager = GridLayoutManager(context, 3)
            addItemDecoration(SellingRecyclerSpacing(4, 4))
        }













    }

    override fun onGetItemDetailSignUpFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostFollowSuccess(response: PostFollowResponse) {
        if(response.code == 1000) {
            binding.itemDetailButtonFollow.setImageResource(R.drawable.button_follow_selected)
        } else {
            binding.itemDetailButtonFollow.setImageResource(R.drawable.button_follow_default)
        }
    }

    override fun onPostFollowFailure(message: String) {
        TODO("Not yet implemented")
    }


    //--------------------------------------------------------------------------홈프래그먼트뷰
    override fun onGetItemSuccess(response: GetItemResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetItemFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onGetCollectionSuccess(response: GetCollectionResponse) {
        dismissLoadingDialog()
        val result = response.result
        if(result.size != 0){
            val temp = ArrayList<Result>()
            temp.addAll(result)
            if(productId != -1){
                CollectionDialog(this, this).showCollectionDialog(temp, productId)
            }

        } else {
            val temp = ArrayList<Result>()
            CollectionDialog(this, this).showCollectionDialog(temp, productId)
        }
    }

    override fun onGetCollectionFailure(message: String) {

    }

    override fun onPostFavoriteSuccess(response: PostFavoriteResponse) {

    }

    override fun onPostFavoriteFailure(message: String) {

    }

    // CustomCallback
    override fun onFavoriteSuccess() {

        binding.itemDetailUserFavorite.setImageResource(R.drawable.home_favorite_selected)
        binding.itemDetailUserFavorite2.setImageResource(R.drawable.home_favorite_selected)
        check = true

    }

    override fun onFavoriteFailure(message: String) {

    }


}