package com.example.bgg89.travelmaker_project

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.view.WindowManager



//import com.example.bgg89.travelmaker_project.GPS.GPSProvider

class MainActivity : AppCompatActivity() {

//    var gps: GPSProvider? = null
    var b1: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        b1 = findViewById(R.id.b1) as Button;
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
