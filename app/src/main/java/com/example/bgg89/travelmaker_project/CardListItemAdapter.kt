package com.example.bgg89.travelmaker_project

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.alexvasilkov.android.commons.adapters.ItemsAdapter

import com.ramotion.expandingcollection.ECCardContentListItemAdapter
import java.util.Random

class CardListItemAdapter(private var activity: TravelListActivity, context : Context, objects: List<String>) : ECCardContentListItemAdapter<String>(context, R.layout.travel_list_item, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder : ViewHolder
        var rowView = convertView

        if(rowView == null){
            val inflater = LayoutInflater.from(context)
            rowView = inflater.inflate(R.layout.travel_list_item, null)
            viewHolder = ViewHolder()
            viewHolder.itemText = rowView!!.findViewById(R.id.list_item_text) as TextView
            rowView.tag = viewHolder
        } else {
            viewHolder = rowView.tag as ViewHolder
        }

        val item = getItem(position)
        if(item != null) {
            viewHolder.itemText!!.text = item
        }
        return rowView
    }

    internal class ViewHolder{
        var itemText : TextView? = null
    }
}