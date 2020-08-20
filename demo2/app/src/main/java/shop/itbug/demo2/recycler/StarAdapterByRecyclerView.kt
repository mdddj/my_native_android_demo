package shop.itbug.demo2.recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import shop.itbug.demo2.R
import shop.itbug.demo2.entry.Star

class StarAdapterByRecyclerView(val starsList: List<Star>) :
    RecyclerView.Adapter<StarAdapterByRecyclerView.ViewHolder>() {

    private val tag = "StarAdapterByRecyclerView"

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val starImage: ImageView = view.findViewById(R.id.starImage)
        var starName: TextView = view.findViewById(R.id.starName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.star_item_staggered, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val star = starsList[position]
            Toast.makeText(parent.context,"你点击了 ${star.name} 的卡片",Toast.LENGTH_SHORT).show()
        }
        viewHolder.starImage.setOnClickListener{
            val position = viewHolder.adapterPosition
            val star = starsList[position]
            Toast.makeText(parent.context,"你点击了 ${star.name} 的头像",Toast.LENGTH_SHORT).show()
        }

        return viewHolder
    }

    override fun getItemCount() = starsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var star = starsList[position]
        holder.starImage.setImageResource(star.image)
        holder.starName.text = star.name
    }
}