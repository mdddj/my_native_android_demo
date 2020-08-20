package com.example.demo2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extraData = intent.getStringExtra("data")
        Log.d("Second Activity","上一个页面的数据是:$extraData")

        button2.setOnClickListener{
            val intent = Intent()
            intent.putExtra("data_return","你好呀,我是返回来的数据")
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return","你好呀,我是返回来的数据")
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}