package com.nosorae.bunjang_a_mock_android_noah.src.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityMainBinding
import com.nosorae.bunjang_a_mock_android_noah.src.main.bungae_talk.BungaeTalkFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.following.FollowingFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.home.HomeFragment
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopFragment
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.AddItemGalleryActivity
import java.lang.Thread.sleep
import kotlin.concurrent.thread

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
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
                        checkPermission()
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

    fun checkPermission(){
        var check = true
        for(permission in permissions){
            val isPerm = ContextCompat.checkSelfPermission(this, permission)
            if(isPerm != PackageManager.PERMISSION_GRANTED){
                check = false
            }
        }
        if(check){
            startProcess()
        }
        else{
            requestPermission()
        }
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 99)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            99 -> {
                for(result in grantResults){
                    if(result == PackageManager.PERMISSION_GRANTED){
                        startProcess()
                    }
                    else{
                        //허용하라고 독촉?
                    }
                }
            }
        }
    }

    fun startProcess() {


        thread {
            runOnUiThread {
                showLoadingDialog(this)
            }
            sleep(3000)
            runOnUiThread {
                dismissLoadingDialog()
            }
        }

        startActivityForResult(Intent(this, AddItemGalleryActivity::class.java), 1)
    }


}