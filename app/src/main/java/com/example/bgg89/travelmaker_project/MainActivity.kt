package com.example.bgg89.travelmaker_project

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.icu.lang.UCharacter.GraphemeClusterBreak.V


import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

import com.alexvasilkov.android.commons.texts.SpannableBuilder
import com.alexvasilkov.foldablelayout.UnfoldableView
import com.alexvasilkov.android.commons.adapters.ItemsAdapter
import com.alexvasilkov.android.commons.ui.Views
import com.alexvasilkov.android.commons.ui.Views.find

import com.example.bgg89.travelmaker_project.R
import com.example.bgg89.travelmaker_project.Painting
import com.example.bgg89.travelmaker_project.PaintingsAdapter
import com.example.bgg89.travelmaker_project.GlideHelper
import com.alexvasilkov.foldablelayout.shading.GlanceFoldShading
import kotlinx.android.synthetic.main.activity_main_screen.*
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity(){
    //    var gps: GPSProvider? = null
    lateinit var items : List<ActivityInfo>
    lateinit var text2 : TextView
    lateinit var parent : ViewGroup
    lateinit var listTouchInterceptor : View
    lateinit var detailsLayout : View
    lateinit var unfoldableView : UnfoldableView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
//        b1 = findViewById(R.id.b1) as Button;

        setContentView(R.layout.activity_unfoldable_details)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var listView : ListView = find(this, R.id.list_view)
        listView.adapter = PaintingsAdapter(this)

        listTouchInterceptor = find(this, R.id.touch_interceptor_view)
        listTouchInterceptor.isClickable = false

        detailsLayout = find(this, R.id.details_layout)
        detailsLayout.visibility = View.INVISIBLE

        unfoldableView = find(this, R.id.unfoldable_view)

        var glance : Bitmap = BitmapFactory.decodeResource(resources, R.drawable.unfold_glance)
        unfoldableView.setFoldShading(GlanceFoldShading(glance))

        unfoldableView.setOnFoldingListener(object:UnfoldableView.SimpleFoldingListener() {
            override fun onUnfolding(unfoldableView:UnfoldableView) {
                listTouchInterceptor.isClickable = true
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
        val image : ImageView = find(detailsLayout, R.id.details_image)
        val timer = Timer()
        GlideHelper().loadPaintingImage(image, painting)
        val nextIntent = Intent(this@MainActivity, TravelListActivity::class.java)
        if(painting.title == "Starry Night"){
            nextIntent.putExtra("Kind", "Schedule")
        } else if(painting.title == "Cafe Terrace at Night"){
            nextIntent.putExtra("Kind", "Spend")
        }

        unfoldableView.unfold(coverView, detailsLayout)
        timer.schedule(timerTask {
            startActivityForResult(nextIntent, 1)
            overridePendingTransition(0, 0)
     //       finish()
        }, 522)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        unfoldableView.foldBack()
    }

    fun replay(view: View) {
        val preferenceManager = PreferenceManager(applicationContext)
        preferenceManager.setFirstTimeLaunch(true)
        startActivity(Intent(this@MainActivity, IntroActivity::class.java))
        finish()
    }

//    fun initGPS() {
//        var mlocManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        gps = GPSProvider(this@MainActivity, mlocManager)
////        gps.setMlocListener(mlocListener)
//    }

//    var mlocListener: LocationListener = LocationListener() {
//        fun onLocationChanged(myLocation: Location) { // 사용자의 위치가 변할때마다 그를 감지해내는 메소드
//            checkLocation(myLocation.getLatitude(), myLocation.getLongitude())
//        }
//    }

    fun checkLocation(latitude: Double, longitude: Double) {

    }
}
