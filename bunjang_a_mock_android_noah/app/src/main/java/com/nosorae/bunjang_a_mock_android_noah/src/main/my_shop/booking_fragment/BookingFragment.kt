package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.booking_fragment

import android.os.Bundle
import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentBookingBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.SellingFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult

class BookingFragment :
        BaseFragment<FragmentBookingBinding>(FragmentBookingBinding::bind, R.layout.fragment_booking),
        SellingFragmentView
         {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myBookingContainer.visibility = View.INVISIBLE
     

    }

             override fun onGetSellingSeccess(response: GetMySellingResponse) {
                 TODO("Not yet implemented")
             }

             override fun onGetSellingFailure(messge: String?) {
                 TODO("Not yet implemented")
             }

             override fun onClickCheck(isOn: Int) {
                 TODO("Not yet implemented")
             }

             override fun onClickdelete(isInList: ArrayList<GetMySellingResult>) {
                 TODO("Not yet implemented")
             }
         }
