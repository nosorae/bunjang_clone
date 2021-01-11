package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.booking_fragment

import android.os.Bundle
import android.view.View
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseFragment
import com.nosorae.bunjang_a_mock_android_noah.databinding.FragmentBookingBinding

class BookingFragment :
        BaseFragment<FragmentBookingBinding>(FragmentBookingBinding::bind, R.layout.fragment_booking)
         {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.myBookingContainer.visibility = View.INVISIBLE
     

    }

    
}