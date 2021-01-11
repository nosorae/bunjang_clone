package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentMyShopBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.booking_fragment.BookingFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.configuration_activity.MyShopConfigurationActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.FavoriteCollectionActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.follow_activity.MyFollowActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.model.GetProfileResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.my_shop_dialog.MyShopDialog
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selled_fragment.SelledFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.SellingFragment

class MyShopFragment :
    BaseFragment<FragmentMyShopBinding>(FragmentMyShopBinding::bind, R.layout.fragment_my_shop),
    MyShopFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoadingDialog(context!!)
        MyShopService(this).tryGetProfile()


        activity!!.supportFragmentManager.beginTransaction().replace(R.id.my_selling_fragment, SellingFragment()).commitAllowingStateLoss()

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

        binding.textViewFollowing.setOnClickListener {
            startActivity(Intent(context, MyFollowActivity::class.java))
        }


        binding.myShopCustomTabBooking.setOnClickListener {
           // binding.myShopNonContainer.visibility = View.VISIBLE
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.my_selling_fragment, BookingFragment())
                .commitAllowingStateLoss()
            binding.myShopCustomTabBooking.setTextColor(Color.BLACK)
            binding.myShopCustomTabSelling.setTextColor(Color.LTGRAY)
            binding.myShopCustomTabSelled.setTextColor(Color.LTGRAY)
            binding.myShopCustomTabSellingBar.visibility = View.INVISIBLE
            binding.myShopCustomTabSelledBar.visibility = View.INVISIBLE
            binding.myShopCustomTabBookingBar.visibility = View.VISIBLE
        }

        binding.myShopCustomTabSelled.setOnClickListener {
           // binding.myShopNonContainer.visibility = View.VISIBLE
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.my_selling_fragment, SelledFragment())
                .commitAllowingStateLoss()
            binding.myShopCustomTabSelled.setTextColor(Color.BLACK)
            binding.myShopCustomTabSelling.setTextColor(Color.LTGRAY)
            binding.myShopCustomTabBooking.setTextColor(Color.LTGRAY)
            binding.myShopCustomTabSelledBar.visibility = View.VISIBLE
            binding.myShopCustomTabSellingBar.visibility = View.INVISIBLE
            binding.myShopCustomTabBookingBar.visibility = View.INVISIBLE
        }

        binding.myShopCustomTabSelling.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.my_selling_fragment, SellingFragment())
                .commitAllowingStateLoss()
            binding.myShopCustomTabSelling.setTextColor(Color.BLACK)
            binding.myShopCustomTabSelled.setTextColor(Color.LTGRAY)
            binding.myShopCustomTabBooking.setTextColor(Color.LTGRAY)
            binding.myShopCustomTabSellingBar.visibility = View.VISIBLE
            binding.myShopCustomTabSelledBar.visibility = View.INVISIBLE
            binding.myShopCustomTabBookingBar.visibility = View.INVISIBLE
        }


    }

    override fun onGetProfileSeccess(response: GetProfileResponse) {


            dismissLoadingDialog()
            if(response.result.storeImgUrl != null) {
                Glide.with(context!!).load(response.result.storeImgUrl).into(binding.imageViewProfileImage)
            }
            binding.imageViewProfileImage.setImageResource(R.drawable.no_profile_image)



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
        dismissLoadingDialog()
    }
}