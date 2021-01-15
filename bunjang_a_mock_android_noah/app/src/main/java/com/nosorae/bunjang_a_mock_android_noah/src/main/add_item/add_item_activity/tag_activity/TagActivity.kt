package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.tag_activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityAddItemBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityTagBinding
import java.lang.reflect.Type
import java.util.ArrayList

class TagActivity: BaseActivity<ActivityTagBinding>(ActivityTagBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.tagButtonBack.setOnClickListener {
            finish()
        }
        binding.tagButtonCheck.setOnClickListener {

            val intent = Intent()
            val arr =binding.tagEditText.text.toString().split("#")
            var strArrayList = ArrayList<String>()
            for(str in arr){
                strArrayList.add(str)
            }
            saveArrayList(strArrayList, "tags")
            setResult(RESULT_OK, intent)
            finish()

        }

        binding.tagEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(str: CharSequence?, p1: Int, p2: Int, p3: Int) {
               var check =true
                var check2 = 0
                if(str != null){
                        if(str.lastIndex.toChar() == ' '){
                            check = false
                        }

               }
                var cur = str.toString()
                var next = cur

                //마지막이 띄어쓰기면 일단 #으로 바꿔주고

                if(!check) {
                    cur = str.toString()
                    next = cur.substring(0, cur.length-1)+"#"
                    binding.tagEditText.setText(next)
                }

                var i = 0
                for(i in 0..next.length-1){
                    if(next[i] == '#'){
                        check2 += 1
                    }
                }

                if(check2 >= 6){
                    next = next.substring(0, cur.length-1)
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

    }

    fun saveArrayList(list: java.util.ArrayList<String>?, key: String?) {
        val prefs = getSharedPreferences("myPreference", Activity.MODE_PRIVATE)
        val editor = prefs.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply() // This line is IMPORTANT !!!
    }



}