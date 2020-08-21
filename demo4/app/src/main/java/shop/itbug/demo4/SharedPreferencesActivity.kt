package shop.itbug.demo4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        add.setOnClickListener(this)
        find.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            add -> {
                add()
            }
            find -> {
                find()
            }
        }
    }

    private fun add() {
        val edit = getSharedPreferences("datas", Context.MODE_PRIVATE).edit()
        val value : EditText = findViewById<EditText>(R.id.inputEdit)
        edit.apply(){
            putString("value",value.text.toString())
            apply()
        }
        Toast.makeText(this,"添加数据成功",Toast.LENGTH_SHORT).show()
    }

    private fun find() {

    }
}