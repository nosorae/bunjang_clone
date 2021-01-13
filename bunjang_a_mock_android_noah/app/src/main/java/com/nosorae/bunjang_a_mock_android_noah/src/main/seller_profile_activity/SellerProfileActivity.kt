package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivitySellerProfileBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity.model.GetSellerProfileResponse

class SellerProfileActivity : BaseActivity<ActivitySellerProfileBinding>(ActivitySellerProfileBinding::inflate),
                              SellerProfileActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sellerId = intent.getIntExtra("sellerId", 1)
        showLoadingDialog(this)
        SellerProfileService(this).trySellerGetProfile(sellerId)
    }

    override fun onGetSellerProfileSeccess(response: GetSellerProfileResponse) {
        dismissLoadingDialog()
        val info = response.result.info
        binding.sellerProfileTextProductNum.text = info.productCount.toString()
        binding.sellerProfileTextReviewNum.text = info.reviewCount.toString()
        binding.sellerProfileTextFollowingNum.text = info.followingCount.toString()
        binding.sellerProfileTextFollowerNum.text = info.followerCount.toString()
        binding.sellerProfileNumOfOpen.text = info.openDay.toString()
        binding.sellerProfileNumOfVisitor.text = info.visitCount.toString()
        Glide.with(this).load(info.storeImgUrl).into(binding.sellerProfileImage)




        //binding.sell
    }

    override fun onGetSellerProfileFailure(messge: String?) {
        dismissLoadingDialog()
    }
}