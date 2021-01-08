package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyShopBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.configuration_activity.MyShopConfigurationActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.FavoriteCollectionActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.my_shop_dialog.MyShopDialog

class MyShopFragment :
    BaseFragment<FragmentMyShopBinding>(FragmentMyShopBinding::bind, R.layout.fragment_my_shop),
    MyShopFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MyShopService(this).tryGetProfile()

        binding.imageButtonPreferences.setOnClickListener {
            startActivity(Intent(context, MyShopConfigurationActivity::class.java))
        }
        binding.textViewLike.setOnClickListener {
            startActivity(Intent(context, FavoriteCollectionActivity::class.java))
        }
        binding.myShopProfileContainer.setOnClickListener {
            MyShopDialog(context!!).showLogInDialog()
        }


    }

    override fun onGetProfileSeccess(response: GetProfileResponse) {
        /**
          //  if(response.getProfileResult.storeImgUrl != null){
               // Glide.with(context!!).load(response.getProfileResult.storeImgUrl).into(binding.imageViewProfileImage)
          //  }
            binding.textViewShopName.text = response.getProfileResult.storeName
            //if(response.getProfileResult.starRatinvAvg != null) {
                //binding.ratingBar.rating = response.getProfileResult.starRatinvAvg as Float
          //  }
            binding.textViewLike.text = response.getProfileResult.pickCount.toString()
            binding.textViewReview.text = response.getProfileResult.reviewCount.toString()
            binding.textViewFollower.text = response.getProfileResult.followerCount.toString()
            binding.textViewFollowing.text = response.getProfileResult.followingCount.toString()
**/
    }

    override fun onGetProfileFailure(messge: String?) {
        TODO("Not yet implemented")
    }
}