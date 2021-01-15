package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.description_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import com.nosorae.bunjang_a_mock_android_noah.R
import com.nosorae.bunjang_a_mock_android_noah.config.BaseActivity
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivityInputDescriptionBinding
import com.nosorae.bunjang_a_mock_android_noah.databinding.ActivitySelectCategoryBinding

class InputDescriptionActivity : BaseActivity<ActivityInputDescriptionBinding>(ActivityInputDescriptionBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val editText = binding.inputDescEditText
        editText.setOnFocusChangeListener { view, b ->
            if(b){
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
            }

        }

        editText.requestFocus()

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val input = editText.text.toString()
                binding.inputDescNumOfText.setText(input.length.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.inputDescButtonDone.setOnClickListener {
            val intent = Intent()
            intent.putExtra("description", editText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.inputDescButtonBack.setOnClickListener {
            finish()
        }

    }
}