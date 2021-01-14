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
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdReceiver
import com.google.firebase.iid.InstanceIdResult
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.AddItemGalleryActivity
import java.lang.Thread.sleep
import kotlin.concurrent.thread

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener(object : OnCompleteListener<InstanceIdResult>{
            override fun onComplete(task: Task<InstanceIdResult>) {
                if(!task.isSuccessful){
                    return
                }
                val token = task.getResult()!!.token
                Log.d("FCM Log", "FCM 토큰: "+token)
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            }
        })


        val whichAction = intent.getStringExtra("whichAction")

       if(whichAction != null && whichAction.equals("1")){
            val myBundle = Bundle()
            val itemIdStr = intent.getStringExtra("itemId")
            var itemId = 1
           if(itemIdStr != null) {
               itemId = itemIdStr.toInt()
           }
            myBundle.putInt("itemId", itemId)
            val myFragment = HomeFragment()
            myFragment.arguments = myBundle
           supportFragmentManager.beginTransaction().replace(R.id.main_frm, myFragment).commitAllowingStateLoss()

       } else {
           supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
       }






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