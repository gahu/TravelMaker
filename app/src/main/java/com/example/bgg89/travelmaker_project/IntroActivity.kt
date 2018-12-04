package com.example.bgg89.travelmaker_project

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.example.bgg89.travelmaker_project.Common.CustomProgressDialog
import com.example.bgg89.travelmaker_project.Common.FontUtils

/**
 * Created by bgg89 on 2018-11-21.
 */

class IntroActivity : AppCompatActivity() {

    var loading: CustomProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screen)
        val myThread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(1200)
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        myThread.start()

//        loading = CustomProgressDialog.show(this, "", "")
//        loading.setCancelable(false)
//        loading.show()
//
//        checkPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    }

//    @Override
//    fun setContentView(layoutResID: Int) {
//        super.setContentView(layoutResID)
////        FontUtils.getInstance(this@IntroActivity).setGlobalFont(getWindow().getDecorView())
//    }

    fun startApp() {  }

//    fun checkPermission(checkPermission: String) {
//        var requestCode : Int = 0
//        var message : String = ""
//        if(checkPermission.equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
//            requestCode = 1
//            message = "위치정보 사용"
//        }
//
//        if(ContextCompat.checkSelfPermission(this@IntroActivity, checkPermission)
//                != PackageManager.PERMISSION_GRANTED) {
//            // should we show an explanation?
//            if(ActivityCompat.shouldShowRequestPermissionRationale(this@IntroActivity,
//                            checkPermission)) {
//                // Show an expanation to the user *asynchronously* -- don't block
//                // this thread waiting for the user's response! After the user
//                // sees the explanation, try again to request the permission.
//                val builder = AlertDialog.Builder(this)
//                val finalRequestCode : Int = requestCode
//                builder.setMessage(FontUtils.getInstance(this).typeface("안드로이드 v6.0부터 앱별로 별도 권한설정이 필요합니다.\n앱 설정 에서 $message 권한\n허가후 앱을 재실행해 주십시요."))
//                        .setCancelable(false)
//                        .setNegativeButton("허가 안함", DialogInterface.OnClickListener { dialogInterface, i -> finishApp() })
//                builder.setPositiveButton("앱 설정") { dialog, which ->
//                    try {
//                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//                                .setData(Uri.parse("package:$packageName"))
//                        startActivity(intent)
//                        finish()
//                    } catch (e: ActivityNotFoundException) {
//                        val intent = Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS)
//                        startActivity(intent)
//                        finish()
//                    }
//                }
//            }
//
//        }
//    }

//    fun onRequestPermissionsResult(requestCode: Int, permission: Array <String>,
//                                   grantResults: Array<Int>) {
//        // same switch
//        when (requestCode) {
//            requestCode in 1 -> {
//                // if request is cancelled, the result arrays are empty.
//                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    if(null) {
//
//                    }
//                    startApp()
//                } else {
////                    finishApp()
//                }
//                break
//            }
//        }
    }

//    fun finishApp() {
//        AlertDialog.Builder ad = new AlertDialog.Builder(IntroActivity.this)
//        ad.setTitle()
//                .setMessage()
//                .setCancelable(false)
//                .setPositiveButton("확인", (dialog, whichButton) -> {
//                    if()
//        })
//    }
//}
