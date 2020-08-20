package shop.itbug.demo2.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shop.itbug.demo2.R

sealed class MessageViewHodler (view: View) : RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View) : MessageViewHodler(view){
    val leftMessage : TextView = view.findViewById(R.id.leftMsg)
}

class RightViewHolder(view: View) : MessageViewHodler(view){
    val rightMessage : TextView =  view.findViewById(R.id.rightMsg)
}