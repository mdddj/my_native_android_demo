package shop.itbug.demo4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        val inputText = load()
//        if(inputText.isNotEmpty()){
//            inputEdit.setText(inputText)
//            inputEdit.setSelection(inputText.length)
//            Toast.makeText(this,"加载本地文件成功",Toast.LENGTH_SHORT).show()
//        }
//        button1.setOnClickListener{
//            val intent = Intent(this,SharedPreferencesActivity::class.java)
//            startActivity(intent)
//        }

//        supportActionBar?.let {
//            it.setDisplayHomeAsUpEnabled(true)
//            it.setHomeAsUpIndicator(R.drawable.menu)
//        }
        navMenu.setCheckedItem(R.id.home)
        navMenu.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
//        val inputText = inputEdit.text.toString()
//        save(inputText)
        Log.d("MainActivity", "程序销毁")
    }

    private fun save(inputText: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val white = BufferedWriter(OutputStreamWriter(output))
            white.use {
                it.write(inputText)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }
}