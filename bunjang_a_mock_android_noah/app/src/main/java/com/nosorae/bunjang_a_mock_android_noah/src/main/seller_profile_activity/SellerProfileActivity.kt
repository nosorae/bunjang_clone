package com.nosorae.bunjang_a_mock_android_noah.src.main.seller_profile_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        //binding.sell
    }

    override fun onGetSellerProfileFailure(messge: String?) {
        dismissLoadingDialog()
    }
}