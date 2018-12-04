package com.example.bgg89.travelmaker_project

import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import java.lang.NullPointerException
import android.annotation.SuppressLint
import android.support.annotation.NonNull

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item != null){
            if(item.itemId == android.R.id.home){
                onBackPressed()
                return true
            } else {
                return super.onOptionsItemSelected(item)
            }
        } else {
            return super.onOptionsItemSelected(item)
        }
    }

    @NonNull
    override fun getSupportActionBar(): ActionBar? {
        val actionBar = super.getSupportActionBar()
        if(actionBar == null){
            val e = NullPointerException("Action bar was not init")
            throw e
        }
        return actionBar
    }
}