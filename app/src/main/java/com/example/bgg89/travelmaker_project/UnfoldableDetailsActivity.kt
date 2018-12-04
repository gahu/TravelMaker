package com.example.bgg89.travelmaker_project

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

import com.alexvasilkov.android.commons.texts.SpannableBuilder
import com.alexvasilkov.android.commons.ui.Views
import com.alexvasilkov.foldablelayout.UnfoldableView

import com.example.bgg89.travelmaker_project.R
import com.example.bgg89.travelmaker_project.Painting
import com.example.bgg89.travelmaker_project.PaintingsAdapter
import com.example.bgg89.travelmaker_project.GlideHelper
import com.alexvasilkov.foldablelayout.shading.GlanceFoldShading

class UnfoldableDetailsActivity : BaseActivity() {
    lateinit var listTouchInterceptor : View
    lateinit var detailsLayout : View
    lateinit var unfoldableView : UnfoldableView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unfoldable_details)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var listView : ListView = Views.find(this, R.id.list_view)
        listView.adapter = PaintingsAdapter(this)

        listTouchInterceptor = Views.find(this, R.id.touch_interceptor_view)
        listTouchInterceptor.isClickable = false

        detailsLayout = Views.find(this, R.id.details_layout)
        detailsLayout.visibility = View.INVISIBLE

        unfoldableView = Views.find(this, R.id.unfoldable_view)

        var glance : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.unfold_glance)
        unfoldableView.setFoldShading(GlanceFoldShading(glance))

        unfoldableView.setOnFoldingListener(object:UnfoldableView.SimpleFoldingListener() {
            override fun onUnfolding(unfoldableView:UnfoldableView) {
                listTouchInterceptor.setClickable(true)
                detailsLayout.visibility = View.VISIBLE
            }
            override fun onUnfolded(unfoldableView:UnfoldableView) {
                listTouchInterceptor.isClickable = false
            }
            override fun onFoldingBack(unfoldableView:UnfoldableView) {
                listTouchInterceptor.isClickable = true
            }
            override fun onFoldedBack(unfoldableView:UnfoldableView) {
                listTouchInterceptor.isClickable = false
                detailsLayout.visibility = View.INVISIBLE
            }
        })
    }

    override fun onBackPressed() {
        if(unfoldableView != null && (unfoldableView.isUnfolded || unfoldableView.isUnfolding)){
            unfoldableView.foldBack()
        } else {
            super.onBackPressed()
        }
    }

    fun openDetails(coverView : View, painting : Painting){
        val image : ImageView = Views.find(detailsLayout, R.id.details_image)
        val title : TextView = Views.find(detailsLayout, R.id.details_title)
        val description : TextView = Views.find(detailsLayout, R.id.details_text)

        GlideHelper().loadPaintingImage(image, painting)
        title.text = painting.title

        val builder : SpannableBuilder = SpannableBuilder(this)
        builder.createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .append(R.string.year).append(": ")
                .clearStyle()
                .append(painting.year).append("\n")
                .createStyle().setFont(Typeface.DEFAULT_BOLD).apply()
                .clearStyle()
                .append(painting.location)
        description.text = builder.build()

        unfoldableView.unfold(coverView, detailsLayout)
    }
}