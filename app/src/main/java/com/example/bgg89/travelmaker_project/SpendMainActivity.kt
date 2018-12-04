package com.example.bgg89.travelmaker_project

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.text.format.DateFormat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import devs.mulham.horizontalcalendar.HorizontalCalendar

import java.util.ArrayList
import java.util.Calendar
import java.util.Random

import devs.mulham.horizontalcalendar.model.CalendarEvent
import devs.mulham.horizontalcalendar.utils.CalendarEventsPredicate
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener

class SpendMainActivity : AppCompatActivity() {
    private var horizontalCalendar : HorizontalCalendar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spend_main)
//        val startDate = Calendar.getInstance()
//        startDate.set(Calendar.YEAR, 2018)
//        startDate.set(Calendar.MONTH, -2)
//        startDate.set(Calendar.DAY_OF_MONTH, 14)
//
//        val endDate = Calendar.getInstance()
//        endDate.set(Calendar.YEAR, 2018)
//        endDate.set(Calendar.MONTH, 2)
//        endDate.set(Calendar.DAY_OF_MONTH, 18)
//
//        val defaultSelectedDate = Calendar.getInstance()
//
//        horizontalCalendar = HorizontalCalendar.Builder(this, R.id.calendarView)
//                .range(startDate, endDate)
//                .datesNumberOnScreen(5)
//                .build()
//                //.build()
//                .configure()
//                .formatTopText("MMM")
//                .formatMiddleText("dd")
//                .formatBottomText("EEE")
//                .showTopText(true)
//                .showBottomText(true)
//                .textColor(Color.LTGRAY, Color.WHITE)
//                .colorTextMiddle(Color.LTGRAY, Color.parseColor("#ffd54f"))
//                .end()
//                .defaultSelectedDate(defaultSelectedDate)
//                .addEvents(object : CalendarEventsPredicate {
//
//                    internal var rnd = Random()
//                    override fun events(date: Calendar): List<CalendarEvent> {
//                        val events = ArrayList<CalendarEvent>()
//                        val count = rnd.nextInt(6)
//
//                        for (i in 0..count) {
//                            events.add(
//                                    CalendarEvent(
//                                            Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)),
//                                            "event"
//                                    )
//                            )
//                        }
//
//                        return events
//                    }
//                })
//                .build()
//
//        Log.i("Default Date", DateFormat.format("EEE, MMM d, yyyy", defaultSelectedDate).toString())
//
//        horizontalCalendar?.calendarListener = object : HorizontalCalendarListener(){
//            override fun onDateSelected(date: Calendar?, position: Int) {
//                val selectedDateStr = DateFormat.format("EEE, MMM d, yyyy", date).toString()
//                Toast.makeText(this@SpendMainActivity, "$selectedDateStr selected!", Toast.LENGTH_SHORT).show()
//                Log.i("onDateSelected", "$selectedDateStr - Position = $position")
//            }
//
//            override fun onDateLongClicked(date: Calendar?, position: Int): Boolean {
//                return super.onDateLongClicked(date, position)
//            }
//        }
//
//        val fab = findViewById<FloatingActionButton>(R.id.fab)
//        fab.setOnClickListener { horizontalCalendar!!.goToday(false) }
//    }
    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.horizontal_calendar_items, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        val id = item!!.itemId
//
//        return if(id == R.id.action_settings){
//            true
//        } else return super.onOptionsItemSelected(item)
//    }
}