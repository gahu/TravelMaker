package com.example.bgg89.travelmaker_project

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexvasilkov.android.commons.adapters.ItemsAdapter
import com.alexvasilkov.android.commons.ui.ContextHelper
import com.alexvasilkov.android.commons.ui.Views
//import com.example.bgg89.travelmaker_project.FoldableListActivity

class PaintingsAdapter internal constructor (context:Context):ItemsAdapter<Painting, PaintingsAdapter.ViewHolder>(), View.OnClickListener {
    init{
        var temp = Painting.getAllPaintings(context.resources)
        var li = temp.toList()
        itemsList = li
    }
    override protected fun onCreateHolder(parent:ViewGroup, viewType:Int):ViewHolder {
        val holder = ViewHolder(parent)
        holder.image.setOnClickListener(this)
        return holder
    }
    override protected fun onBindHolder(holder:ViewHolder, position:Int) {
        val item = getItem(position)
        holder.image.setTag(R.id.list_item_image, item)
        GlideHelper().loadPaintingImage(holder.image, item)
        holder.title.setText(item.title)
    }

    override fun onClick(view:View) {
        val item : Painting = view.getTag(R.id.list_item_image) as Painting
        if(item.title == "Starry Night" || item.title == "Cafe Terrace at Night"){
            item.imageId = R.drawable.attractions
            val activity : Activity = ContextHelper.asActivity(view.context)

            if (activity is MainActivity)
            {
                (activity as MainActivity).openDetails(view, item)
            }
        }
    }
    class ViewHolder(parent:ViewGroup):ItemsAdapter.ViewHolder(Views.inflate(parent, R.layout.list_item)) {
        val image:ImageView
        val title:TextView
        init{
            image = Views.find(itemView, R.id.list_item_image)
            title = Views.find(itemView, R.id.list_item_title)
        }
    }
}
