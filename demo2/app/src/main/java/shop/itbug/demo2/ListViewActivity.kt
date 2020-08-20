package shop.itbug.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*
import shop.itbug.demo2.adapter.StarAdapter
import shop.itbug.demo2.entry.Star

class ListViewActivity : AppCompatActivity() {

    private val data = ArrayList<Star>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        init()
        var adapter = StarAdapter(this,R.layout.star_item,data)
        listView.adapter = adapter
        listView.setOnItemClickListener{parent, view, position, id ->
            val star = data[position]
            Toast.makeText(this,star.name,Toast.LENGTH_SHORT).show()
        }
    }

    private fun init(){
        repeat(3){
            data.add(Star("刘亦菲",R.drawable.lyf))
            data.add(Star("杨幂",R.drawable.ym))
            data.add(Star("欧阳娜娜",R.drawable.oynn))
            data.add(Star("沙溢",R.drawable.sy))
            data.add(Star("androidlababy",R.drawable.yy))
        }
    }
}