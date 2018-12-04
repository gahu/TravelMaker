package com.example.bgg89.travelmaker_project

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.TextView

import com.ramotion.expandingcollection.ECBackgroundSwitcherView
import com.ramotion.expandingcollection.ECCardData
import com.ramotion.expandingcollection.ECPagerView
import com.ramotion.expandingcollection.ECPagerViewAdapter
import kotlinx.android.synthetic.main.activity_main_screen.*

class TravelListActivity : AppCompatActivity() {
    private var ecPagerView : ECPagerView? = null
    private val kind by lazy { intent.extras["Kind"] as String }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travellist)

        ecPagerView = findViewById<View>(R.id.ec_pager_element) as ECPagerView

        val dataset = CardData.generateExampleData()
        val ecPagerViewAdapter = object : ECPagerViewAdapter(applicationContext, dataset){
            override fun instantiateCard(
                    inflaterService : LayoutInflater,
                    head : ViewGroup,
                    list : ListView,
                    data : ECCardData<*>
            ) {
                val cardData = data as CardData
                val listItems = cardData.listItems
                val listItemAdapter = CardListItemAdapter(this@TravelListActivity, applicationContext, listItems)
                list.adapter = listItemAdapter
                list.setBackgroundColor(Color.WHITE)

                val cardTitle = TextView(applicationContext)
                cardTitle.text = cardData.cardTitle
                cardTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f)
                val layoutParams = FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
                )
                layoutParams.gravity = Gravity.CENTER
                head.addView(cardTitle, layoutParams)

                head.setOnClickListener {
                    if(kind == "Schedule"){
                        val nextIntent = Intent(this@TravelListActivity, ScheduleMainActivity::class.java)
                        startActivity(nextIntent)
                    } else if(kind == "Spend"){
                        val nextIntent = Intent(this@TravelListActivity, SpendMainActivity::class.java)
                        startActivity(nextIntent)
                    }
                }
            }
        }

        ecPagerView!!.setPagerViewAdapter(ecPagerViewAdapter)
        ecPagerView!!.setBackgroundSwitcherView(findViewById<View>(R.id.ec_bg_switcher_element) as ECBackgroundSwitcherView)
        ecPagerViewAdapter.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
    override fun onBackPressed() {
        //if(!ecPagerView!!.collapse())
        val resultIntent = Intent(this, MainActivity::class.java)
        setResult(1, resultIntent)
        super.onBackPressed()
    }
}