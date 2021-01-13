package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.really_delete_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.TextView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.ApplicationClass
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.MyShopService
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.selling_fragment.model.GetMySellingResult


class ReallyDeleteSellingItemDialog(context : Context, val forMyShopCallBack: MyShopFragmentView,
                                    val forSellingItemCallback: MyShopFragmentView, val isInList: ArrayList<GetMySellingResult>) : Dialog(context)  {

    fun showLogInDialog(myTitle: String, myContent: String, myNo: String, myYes: String){

        requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        setContentView(R.layout.dialog_global_yes_or_no)

        val window: Window? = getWindow()
        if (window != null) {
            // 백그라운드 투명
            window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            //val params: WindowManager.LayoutParams = window.getAttributes()
            // 화면에 가득 차도록
            //params.width = WindowManager.LayoutParams.MATCH_PARENT
            // params.height = WindowManager.LayoutParams.MATCH_PARENT

            // 열기&닫기 시 애니메이션 설정
            // params.windowAnimations = R.style.AnimationPopupStyle
            // window.setAttributes(params)
            // UI 중앙정렬
            window.setGravity(Gravity.CENTER)
        }


        val title = findViewById<TextView>(R.id.global_dialog_title)
        val content = findViewById<TextView>(R.id.global_dialog_content)
        val no = findViewById<TextView>(R.id.global_dialog_button_no)
        val yes = findViewById<TextView>(R.id.global_dialog_button_yes)
        title.visibility = View.GONE
        content.text = myContent
        no.text =myNo
        yes.text= myYes

        no.setOnClickListener {
            dismiss()
        }
        yes.setOnClickListener {

            //showLoadingDialog(context!!)
            val pref = ApplicationClass.sSharedPreferences
            val editor = pref.edit()
            editor.putInt("isDelete", 1)
            editor.apply()

            for(obj in isInList) {
                MyShopService(forMyShopCallBack).tryDeleteItem(obj.productId)
            }
            forSellingItemCallback.onClickDeleteButton()
            dismiss()
        }



        show()
    }

}