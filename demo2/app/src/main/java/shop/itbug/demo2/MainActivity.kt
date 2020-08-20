package shop.itbug.demo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag,"on create...")
        startNormalActivity.setOnClickListener{
            val intent = Intent(this,NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener{
            val intent = Intent(this,DialogActivity::class.java)
            startActivity(intent)
        }
        startWeightActivity.setOnClickListener{
            val intent = Intent(this,LayoutWeightActivity::class.java)
            startActivity(intent)
        }
        startRelativeLayoutActivity.setOnClickListener{
            val intent = Intent(this,RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
        startListViewActivity.setOnClickListener{
            val intent = Intent(this,ListViewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"on start...")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"on resume...")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"on pause...")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"on stop...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"on destory...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"on restart...")
    }
}