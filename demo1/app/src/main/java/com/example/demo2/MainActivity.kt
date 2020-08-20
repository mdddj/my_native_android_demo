package com.example.demo2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MESSAGE = "MainActivity.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            Toast.makeText(this, " 啊, 你点击我了~~~", Toast.LENGTH_SHORT).show()
            val data = "hello 我是来的数据"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", data)
//            startActivity(intent)
//            val intent = Intent("com.example.demo2.ACTION_START")
//            intent.addCategory("com.example.demo2.MY_CATEGORY")
            startActivityForResult(intent,1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "你点击了添加", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "你点击了删除", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            1 -> if(resultCode== Activity.RESULT_OK){
                val returnData = data?.getStringExtra("data_return")
                Log.d("MainActivity","第二个页面返回了数据: $returnData")
            }
        }
    }
}
