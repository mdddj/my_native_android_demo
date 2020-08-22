package com.example.materialcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.materialcardview.adapter.GoodsAdapter
import com.example.materialcardview.entry.Goods
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val goods = mutableListOf<Goods>(
        Goods("台湾风味手工牛扎夹心饼干480g","https://static.saintic.com/picbed/huang/2020/08/22/1598090062677.png","19.6"),
        Goods("热巴同款【金纺】衣物柔顺剂8L","https://static.saintic.com/picbed/huang/2020/08/22/1598090100686.png","69.9"),
        Goods("送视频会员！安卓苹果原装正品耳机","https://static.saintic.com/picbed/huang/2020/08/22/1598090118815.png","6.8"),
        Goods("【拍2件】徐福记零食大礼包720g*2件","https://static.saintic.com/picbed/huang/2020/08/22/1598090134064.png","19.9")
    )

    val goodsList = ArrayList<Goods>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.menu)
        }
        navView.setCheckedItem(R.id.homePage)
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }

        ininGoods()
        val layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager
        val adapter = GoodsAdapter(this,goodsList)
        recyclerView.adapter = adapter

        swipeRefresh.setColorSchemeColors(R.color.colorAccent)
        swipeRefresh.setOnRefreshListener {
            refreshGoods(adapter)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {
                Toast.makeText(this, "点击了搜索", Toast.LENGTH_SHORT).show()
            }
            R.id.message -> {
                Toast.makeText(this, "点击了消息", Toast.LENGTH_SHORT).show()
            }
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    private fun ininGoods(){
        goodsList.clear()
        repeat(50){
            val index = (0 until goods.size).random()
            goodsList.add(goods[index])
        }
    }


    private fun refreshGoods(adapter: GoodsAdapter){
        thread {
            Thread.sleep(2000)
            runOnUiThread{
                ininGoods()
                adapter.notifyDataSetChanged()
                swipeRefresh.isRefreshing = false
                Toast.makeText(this,"刷新成功",Toast.LENGTH_SHORT).show()
            }
        }
    }



}
