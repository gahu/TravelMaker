package com.example.bgg89.travelmaker_project

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.util.AttributeSet
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import java.util.*

class MergedView(context : Context, attributeSet: AttributeSet?) : LinearLayout(context, attributeSet) {
    var myCalender : HorizontalCalendar? = null

    init{
        val infService = Context.LAYOUT_INFLATER_SERVICE
        val li = context.getSystemService(infService) as LayoutInflater
        val v = li.inflate(R.layout.calendar_sequence, this, false)

        addView(v)

        val startDate = Calendar.getInstance()
//        startDate.set(Calendar.YEAR, 2018)
//        startDate.set(Calendar.MONTH, 12)
        startDate.set(Calendar.DAY_OF_MONTH, 14)

        val endDate = Calendar.getInstance()
//        endDate.set(Calendar.YEAR, 2018)
//        endDate.set(Calendar.MONTH, 12)
        endDate.set(Calendar.DAY_OF_MONTH, 18)

        myCalender = HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build()

        myCalender?.calendarListener = object : HorizontalCalendarListener(){
            override fun onDateSelected(date: Calendar?, position: Int) {

            }
        }
    }
}
