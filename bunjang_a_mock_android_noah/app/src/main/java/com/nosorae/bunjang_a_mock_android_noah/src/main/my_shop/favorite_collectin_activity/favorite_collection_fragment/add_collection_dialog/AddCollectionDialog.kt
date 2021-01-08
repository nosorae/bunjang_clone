package com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.add_collection_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionFragmentView
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.FavoriteCollectionService
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.DeleteFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.GetFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.PatchFavoriteCollectionResponse
import com.nosorae.bunjang_a_mock_android_noah.src.main.my_shop.favorite_collectin_activity.favorite_collection_fragment.model.PostFavoriteCollectionResponse


class AddCollectionDialog(context : Context,
                          val forCallBack: FavoriteCollectionFragmentView,
                          val isModify: Int,
                          val collectionId: Int,
                          val title: String) : Dialog(context), FavoriteCollectionFragmentView  {

    fun showLogInDialog(){

        requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        setContentView(R.layout.dialog_add_collection)

        val window: Window? = getWindow()
        if (window != null) {
            // 백그라운드 투명
            window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
            val params: WindowManager.LayoutParams = window.getAttributes()
            // 화면에 가득 차도록
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            // params.height = WindowManager.LayoutParams.MATCH_PARENT

            // 열기&닫기 시 애니메이션 설정
            // params.windowAnimations = R.style.AnimationPopupStyle
            window.setAttributes(params)
            // UI 하단 정렬
            window.setGravity(Gravity.BOTTOM)


            val editText = findViewById<EditText>(R.id.dialog_add_collection_edit_text)
            editText.setOnFocusChangeListener { view, b ->
                if(b){
                    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
                }

            }

            editText.requestFocus()
            //val manager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        }







        val closeButton = findViewById<ImageView>(R.id.dialog_add_collection_button_close)
        val addButton = findViewById<Button>(R.id.dialog_add_collection_button)
        val editText = findViewById<EditText>(R.id.dialog_add_collection_edit_text)
        val numOfText = findViewById<TextView>(R.id.dialog_add_collection_num)
        if(isModify == 1) {
            editText.setText(title)
            numOfText.text ="("+editText.text.toString().length.toString()+"/10)글자"
        }


        editText.setOnKeyListener { view, i, keyEvent ->
            numOfText.text ="("+editText.text.toString().length.toString()+"/10)글자"
            true
        }





        addButton.setOnClickListener {
            if(isModify == 0) {
                forCallBack.onAddCollectionDialog(editText.text.toString())
            }
            else {
                FavoriteCollectionService(this).tryPatchCollection(collectionId, editText.text.toString())

            }

            dismiss()
        }


        closeButton.setOnClickListener {
            dismiss()
        }
        show()
    }


    override fun onGetCollectionSuccess(response: GetFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onGetCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostCollectionSuccess(response: PostFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onDeleteCollectionSuccess(response: DeleteFavoriteCollectionResponse) {
        TODO("Not yet implemented")
    }

    override fun onDeleteCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPatchCollectionSuccess(response: PatchFavoriteCollectionResponse) {
        val editText = findViewById<EditText>(R.id.dialog_add_collection_edit_text)
        forCallBack.onChangeCollectionDialog(editText.text.toString())
    }

    override fun onPatchCollectionFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onAddCollectionDialog(name: String) {
        TODO("Not yet implemented")
    }

    override fun onChangeCollectionDialog(name: String) {
        TODO("Not yet implemented")
    }
}