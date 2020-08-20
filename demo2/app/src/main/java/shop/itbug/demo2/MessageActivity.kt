package shop.itbug.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_layout_weight.*
import kotlinx.android.synthetic.main.activity_message.*
import kotlinx.android.synthetic.main.activity_recycler.*
import shop.itbug.demo2.adapter.MessageAdapter
import shop.itbug.demo2.entry.Message

class MessageActivity : AppCompatActivity() , View.OnClickListener {


    private val messageList = ArrayList<Message>()

    private lateinit var adapter : MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        initMessageList()
        val layoutManager = LinearLayoutManager(this)
        recyclerViewMessage.layoutManager = layoutManager
        adapter = MessageAdapter(messageList)
        recyclerViewMessage.adapter = adapter
        sendMessage.setOnClickListener(this)
    }

    private fun initMessageList() {
        val msg1 = Message("你好在吗???诗诗",Message.TYPE_RECEIVED)
        messageList.add(msg1)
        val msg2 = Message("你好呀典典",Message.TYPE_SENT)
        messageList.add(msg2)
        val msg3 = Message("诗诗你在干嘛",Message.TYPE_RECEIVED)
        messageList.add(msg3)
    }

    override fun onClick(p0: View?) {
        when(p0){
            sendMessage -> {
               val content = inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg = Message(content,Message.TYPE_SENT)
                    messageList.add(msg)
                    adapter.notifyItemInserted(messageList.size-1)
                    recyclerViewMessage.scrollToPosition(messageList.size-1)
                    inputText.setText("")
                }
            }
        }
    }
}