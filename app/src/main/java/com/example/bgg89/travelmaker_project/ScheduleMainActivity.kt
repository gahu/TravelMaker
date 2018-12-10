package com.example.bgg89.travelmaker_project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Context
import android.content.Intent
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum
import com.nightonke.boommenu.BoomButtons.HamButton
import com.nightonke.boommenu.BoomMenuButton
import com.nightonke.boommenu.ButtonEnum
import com.nightonke.boommenu.Piece.PiecePlaceEnum
import com.nightonke.boommenu.Util

class ScheduleMainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_main)

        val bmb = findViewById<View>(R.id.bmb) as BoomMenuButton
        bmb.buttonEnum = ButtonEnum.Ham
        bmb.piecePlaceEnum = PiecePlaceEnum.HAM_1
        bmb.buttonPlaceEnum = ButtonPlaceEnum.HAM_1

        for(i in 0 until bmb.piecePlaceEnum.pieceNumber()){
            val builder = HamButton.Builder()
                    .normalImageRes(R.drawable.flight)
                    .normalTextRes(R.string.default_text)
                    .subNormalText(R.string.default_subtext.toString())
            bmb.addBuilder(builder)
        }
    }

    override fun onBackPressed() {
        val resultIntent = Intent(this, TravelListActivity::class.java)
        setResult(1, resultIntent)
        super.onBackPressed()
    }
}