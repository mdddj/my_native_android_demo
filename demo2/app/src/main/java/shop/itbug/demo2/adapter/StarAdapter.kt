package shop.itbug.demo2.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import shop.itbug.demo2.R
import shop.itbug.demo2.entry.Star

class StarAdapter(activity: Activity, val resourceId: Int, data: List<Star>) :
    ArrayAdapter<Star>(activity, resourceId, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        var viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val starImage: ImageView = view.findViewById(R.id.starImage)
            val starName: TextView = view.findViewById(R.id.starName)
            viewHolder = ViewHolder(starImage,starName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val star = getItem(position)
        if (star != null) {
            viewHolder.starImage.setImageResource(star.image)
            viewHolder.starName.text = star.name
        }
        return view
    }

    inner class ViewHolder(val starImage: ImageView, val starName: TextView)
}