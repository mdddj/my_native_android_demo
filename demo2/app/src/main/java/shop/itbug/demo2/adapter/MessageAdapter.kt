package shop.itbug.demo2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shop.itbug.demo2.R
import shop.itbug.demo2.entry.Message
import shop.itbug.demo2.recycler.LeftViewHolder
import shop.itbug.demo2.recycler.MessageViewHodler
import shop.itbug.demo2.recycler.RightViewHolder

class MessageAdapter(val msgList: List<Message>) : RecyclerView.Adapter<MessageViewHodler>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == Message.TYPE_RECEIVED) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.message_left, parent, false)
            LeftViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.message_right, parent, false)
            RightViewHolder(view)
        }

    override fun getItemCount() = msgList.size

    override fun onBindViewHolder(holder: MessageViewHodler, position: Int) {
        val msg = msgList[position]
        when(holder){
            is LeftViewHolder -> holder.leftMessage.text = msg.content
            is RightViewHolder -> holder.rightMessage.text = msg.content
        }
    }

    override fun getItemViewType(position: Int): Int {
        return msgList[position].type
    }

}