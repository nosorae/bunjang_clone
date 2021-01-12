package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.item_more_dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.gson.Gson
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.AddItemActivity
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.SellingFragmentView


class ItemMoreDialog(context : Context, val forCallBack: SellingFragmentView, val productId: Int) : Dialog(context)  {

    fun showLogInDialog(){

        requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        setContentView(R.layout.dialog_my_shop_more)

        val window: Window? = getWindow()
        if (window != null) {
            // 백그라운드 투명
            window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            val params: WindowManager.LayoutParams = window.getAttributes()
            // 화면에 가득 차도록
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            // params.height = WindowManager.LayoutParams.MATCH_PARENT

            // 열기&닫기 시 애니메이션 설정
            params.windowAnimations = R.style.AnimationPopupStyle
            window.setAttributes(params)
            // UI 하단 정렬
            window.setGravity(Gravity.BOTTOM)
        }



        val updateButton = findViewById<LinearLayout>(R.id.dialog_my_shop_more_update)
        val closeButton = findViewById<ImageView>(R.id.dialog_my_shop_more_close)

        updateButton.setOnClickListener {
            val temp = ArrayList<String>()
            saveArrayList(temp, "isInList")
            val intent = Intent(context, AddItemActivity::class.java)
            intent.putExtra("isUpdateFromDialog", 1)
            intent.putExtra("updateProductId", productId)
            context!!.startActivity(intent)

            dismiss()
        }

        closeButton.setOnClickListener {
            dismiss()
        }
        show()
    }

    fun saveArrayList(list: java.util.ArrayList<String>?, key: String?) {
        val prefs = context.getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply() // This line is IMPORTANT !!!
    }

}