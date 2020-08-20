package shop.itbug.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*
import shop.itbug.demo2.entry.Star
import shop.itbug.demo2.recycler.StarAdapterByRecyclerView
import java.lang.StringBuilder

class RecyclerActivity : AppCompatActivity() {

    private val data = ArrayList<Star>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        init()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = StarAdapterByRecyclerView(data)
        recyclerView.adapter = adapter
    }

    private fun init() {
        repeat(3) {
            data.add(Star(getRandomLengthString("刘亦菲"), R.drawable.lyf))
            data.add(Star(getRandomLengthString("杨幂"), R.drawable.ym))
            data.add(Star(getRandomLengthString("欧阳娜娜"), R.drawable.oynn))
            data.add(Star(getRandomLengthString("沙溢"), R.drawable.sy))
            data.add(Star(getRandomLengthString("androidlababy"), R.drawable.yy))
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n =  (1..20).random()
        val build = StringBuilder()
        repeat(n) {
            build.append(str)
        }
        return build.toString()
    }

}