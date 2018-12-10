package com.example.bgg89.travelmaker_project

import android.content.res.Resources
import android.content.res.TypedArray
import com.example.bgg89.travelmaker_project.R

class Painting private constructor(imageId:Int, title:String, year:String, location:String) {
    var imageId:Int = 0
    var title:String
    var year:String
    var location:String
    init{
        this.imageId = imageId
        this.title = title
        this.year = year
        this.location = location
    }
    companion object {
        fun getAllPaintings(res:Resources): Array<Painting?> {
            val titles = res.getStringArray(R.array.paintings_titles)
            val years = res.getStringArray(R.array.paintings_years)
            val locations = res.getStringArray(R.array.paintings_location)
            val images = res.obtainTypedArray(R.array.paintings_images)
            val size = titles.size
            val paintings = arrayOfNulls<Painting>(size)

            for (i in 0 until size)
            {
                val imageId = images.getResourceId(i, -1)
                paintings[i] = Painting(imageId, titles[i], years[i], locations[i])
            }
            images.recycle()
            return paintings
        }
    }
}