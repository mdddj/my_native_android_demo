package shop.itbug.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_normal.*

class NormalActivity : AppCompatActivity() , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        alertButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.alertButton -> {
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT)
                AlertDialog.Builder(this).apply {
                    setTitle("提示")
                    setMessage("确认删除这条信息吗?")
                    setCancelable(false)
                    setPositiveButton("确认") { dialogInterface, i -> }
                    setNegativeButton("取消") { dialogInterface, i -> }
                    show()
                }
            }
        }
    }


}