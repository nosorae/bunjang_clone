package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        binding.textViewShopName.setOnClickListener {
            Toast.makeText(context!!, "siodfsdoifjjdij", Toast.LENGTH_LONG).show()

        }


    }

    override fun onGetProfileSeccess(response: GetProfileResponse) {


            Glide.with(context!!).load(response.result.storeImgUrl).into(binding.imageViewProfileImage)


            binding.textViewShopName.text = response.result.storeName
            if(response.result.starRatinvAvg != null) {
                binding.ratingBar.rating = response.result.starRatinvAvg as Float
            }
            binding.textViewLike.text = response.result.pickCount.toString()
            binding.textViewReview.text = response.result.reviewCount.toString()
            binding.textViewFollower.text = response.result.followerCount.toString()
            binding.textViewFollowing.text = response.result.followingCount.toString()

        //binding.textViewShopName.text = "sdaifosajdifoj"
        //binding.textViewShopName.setText(response.getProfileResult.storeName)
    }

    override fun onGetProfileFailure(messge: String?) {
        TODO("Not yet implemented")
    }
}