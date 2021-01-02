package com.nosorae.bunjang_a_mock_android_noah.src.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityMainBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.AddItemFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.BungaeTalkFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.FollowingFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_following -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, FollowingFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_add_item -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, AddItemFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_bungae_talk -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, BungaeTalkFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_my_shop -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyShopFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }

                }
                false
            })
    }
}