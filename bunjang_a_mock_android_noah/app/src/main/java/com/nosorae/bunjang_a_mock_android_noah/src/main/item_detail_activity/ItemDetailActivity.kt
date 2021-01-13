package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity

import android.app.Activity
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityItemDetailBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeService
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.collection_dialog.CollectionDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.model.*
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.OneCategoryActivityView
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.OneCategoryService
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.one_category_activity.model.OneCategoryResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.recycler_view.CustomCallBack
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.follow_dialog.FollowDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.GetItemDetailResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.PostFollowResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.RecentlyViewItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model.Sale
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_selling_item.SellingRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_selling_item.SellingRecyclerSpacing
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.recycler_similar.SimillarRecyclerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager.ItemDetailPagerAdapter
import com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.view_pager.ItemDetailPagerItem
import com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.SellerProfileActivity
import java.lang.reflect.Type


class ItemDetailActivity
    : BaseActivity<ActivityItemDetailBinding>(ActivityItemDetailBinding::inflate) ,
      ItemDetailActivityView, HomeFragmentView, CustomCallBack, OneCategoryActivityView {

    //사진 뷰페이저에 필요
    private var pageItemList = ArrayList<ItemDetailPagerItem>()
    private lateinit var myAdapter : ItemDetailPagerAdapter

    private var recyclerSimillarItemList = ArrayList<OneCategoryResult>()
    private lateinit var recyclerSimillarAdapter : SimillarRecyclerAdapter

    private var recyclerSellingList = ArrayList<Sale>()
    private lateinit var recyclerSellingAdapter  : SellingRecyclerAdapter
    var isFollow = false

    var productId = -1
    var check = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.activityItemDetailScrollView.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            if(i2 > i4) {
                binding.itemDetailTopAppBar.visibility = View.VISIBLE
                binding.itemDetailTopAppBar.alpha = (i2.toFloat()/850.0f)
            }
            else if(i2 < i4) {
                binding.itemDetailTopAppBar.alpha = (i2.toFloat()/850.0f)
                if(i2 == 0) {
                    binding.itemDetailTopAppBar.visibility = View.INVISIBLE
                }

            }
            if(i2 > 1400) {
                binding.itemDetailAppBarItemContainer.visibility = View.VISIBLE
            }
            else {
                binding.itemDetailAppBarItemContainer.visibility = View.INVISIBLE
            }
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
        showLoadingDialog(this)

        OneCategoryService(this).tryGetOneCategory(response.result.info.category)



        //프로필 상세페이지 조회를 위해서
        binding.itemDetailSelllerProfileContainer.setOnClickListener {
            val intent = Intent(this, SellerProfileActivity::class.java)
            intent.putExtra("sellerId", response.result.info.storeId)
            startActivity(intent)
        }

        //최근 본 아이템리스트를 위해서
        var recentlyViewList = getArrayList("recently")
        if(recentlyViewList != null) {

            val now = RecentlyViewItem(response.result.info.productId,
                    response.result.info.productName,
                    response.result.info.price,
                    response.result.productImg[0].imgUrl)

                if(recentlyViewList.size >= 30){
                    recentlyViewList.removeAt(recentlyViewList.size - 1)
                }
                recentlyViewList.add(now)

            saveArrayList(recentlyViewList, "recently")
        } else {
            recentlyViewList = ArrayList<RecentlyViewItem>()
            recentlyViewList.add(RecentlyViewItem(response.result.info.productId,
                    response.result.info.productName,
                    response.result.info.price,
                    response.result.productImg[0].imgUrl))
            saveArrayList(recentlyViewList, "recently")
        }



        //여기서부터 입력
        productId = response.result.info.productId

        binding.itemDetailName.text = response.result.info.productName
        binding.itemDetailAppBarProductName.text = response.result.info.productName
        if(response.result.info.price.toString() != null){
            binding.itemDetailPrice.text = parseToMoney(response.result.info.price.toString())
            binding.itemDetailAppBarPrice.text = parseToMoney(response.result.info.price.toString())
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
        binding.itemDetailAppBarSellerName.text = response.result.info.storeName

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
                binding.itemDetailNumOfFavorite.text = (binding.itemDetailNumOfFavorite.text.toString().toInt() -1).toString()
                showLoadingDialog(this)
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

        }

        pageItemList = ArrayList<ItemDetailPagerItem>()
        for(obj in response.result.productImg) {
            pageItemList.add(ItemDetailPagerItem(obj.imgUrl))
        }
        Glide.with(this).load(pageItemList[0].imageUrl).into(binding.itemDetailAppBarImage)

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
        dismissLoadingDialog()
    }

    override fun onPostFollowSuccess(response: PostFollowResponse) {
        dismissLoadingDialog()
        if(response.code == 1000) {
            binding.itemDetailButtonFollow.setImageResource(R.drawable.button_follow_selected)
            FollowDialog(this, this).showLogInDialog("", "팔로잉 상점의 상품이 등록되면 알림으로\n 받아보시겠어요?", "닫기", "알림 받기")
        } else {
            binding.itemDetailButtonFollow.setImageResource(R.drawable.button_follow_default)
        }
    }

    override fun onPostFollowFailure(message: String) {
        dismissLoadingDialog()
    }

    override fun onClickAgreePush() {
       //여기에 푸쉬알람 코드 작성
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
        dismissLoadingDialog()

    }

    override fun onPostFavoriteSuccess(response: PostFavoriteResponse) {
        dismissLoadingDialog()
    }

    override fun onPostFavoriteFailure(message: String) {
        dismissLoadingDialog()
    }

    // CustomCallback
    override fun onFavoriteSuccess() {
        dismissLoadingDialog()
        //여기서 좋아요 성공 처리
        binding.itemDetailUserFavorite.setImageResource(R.drawable.home_favorite_selected)
        binding.itemDetailUserFavorite2.setImageResource(R.drawable.home_favorite_selected)
        binding.itemDetailNumOfFavorite.text = (binding.itemDetailNumOfFavorite.text.toString().toInt()+1).toString()
        check = true

    }

    override fun onFavoriteFailure(message: String) {
        dismissLoadingDialog()

    }



    //-------------------------------OneCategoryView
    override fun onGetOneCategorySuccess(response: OneCategoryResponse) {
        dismissLoadingDialog()
        binding.itemDetailSimilarHeader.visibility = View.VISIBLE
        binding.withSimilar.visibility = View.VISIBLE
        recyclerSimillarItemList = ArrayList<OneCategoryResult>()
        val temp = response.result as ArrayList<OneCategoryResult>
        var i = 1
        while(i <= 6){
            recyclerSimillarItemList.add(temp[i])
        i+=1
         }
        recyclerSimillarAdapter = SimillarRecyclerAdapter(this, recyclerSimillarItemList)
        binding.itemDetailRecyclerSimilar.apply {
            adapter = recyclerSimillarAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun onGetOneCategoryFailure(message: String) {
        dismissLoadingDialog()

    }

    //--------------------------------------------------------------------------------------------------
    fun saveArrayList(list: java.util.ArrayList<RecentlyViewItem>?, key: String?) {
        val prefs = getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply() // This line is IMPORTANT !!!
    }

    fun getArrayList(key: String?): java.util.ArrayList<RecentlyViewItem>? {
        val prefs = getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val gson = Gson()
        val json = prefs.getString(key, null)
        val type: Type = object : TypeToken<java.util.ArrayList<RecentlyViewItem?>?>() {}.getType()
        return gson.fromJson(json, type)
    }


}