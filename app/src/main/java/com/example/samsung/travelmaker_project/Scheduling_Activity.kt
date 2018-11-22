package com.example.samsung.travelmaker_project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum
import com.nightonke.boommenu.BoomButtons.HamButton
import com.nightonke.boommenu.BoomMenuButton
import com.nightonke.boommenu.ButtonEnum
import com.nightonke.boommenu.Piece.PiecePlaceEnum
import com.nightonke.boommenu.Util
import com.transferwise.sequencelayout.SequenceLayout
import java.util.*
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener





class Scheduling_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startDate = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -12)


        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 12)

        val horizontalCalendar = HorizontalCalendar.Builder(this, R.id.calendarView)
            .range(startDate, endDate)
            .datesNumberOnScreen(5)
            .build()

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Calendar, position: Int) {
                //do something
            }
        }

        val bmb = findViewById<View>(R.id.bmb) as BoomMenuButton
        // resource 의 activity_main 에서 bmb 라는 boomMenu 버튼의 view를 가져와라

        bmb.setButtonEnum(ButtonEnum.Ham);
        // boomMenu bmb 의 타입을 햄타입으로 지정 (직사각형의 item)

        // bmb 는 2개의 직사가형의 menu item을 갖는 boom menu 버튼

        bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_4);
        // boom menu 버튼 icon 에 2개의 item 만을 표시

        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_4);
        // boom menu 버튼을 눌렀을 떄, 2개의 item이 나타나도록 함

        bmb.setBottomHamButtonTopMargin(Util.dp2px(50f).toFloat());
        // 가장 아래의 boomMenu item button 은 바로 위의 item 버튼과 일정 거리를 두어
        // 그 기능을 구분하도록 함

        // --------------  boomMenu 의 property(내부적 특징) 설정 완료 -----------------

        for (i in 0 until bmb.piecePlaceEnum.pieceNumber()) {  // 0,1,2,...bmb.piecePlaceEnum.pieceNumer() - 1
            val builder = HamButton.Builder()  //  먼저 각 item 버튼에 대한 builder 를 만들고
                .normalImageRes(R.drawable.airplane) // image 리소스 설정
                .normalTextRes(R.string.item_text)   //  내부 메인 텍스트 설정
                .subNormalTextRes(R.string.item_sub_text) // 내부 서브 텍스트 설정
            bmb.addBuilder(builder)  // 각 버튼에 builder 를 추가
        }

        val Items = listOf<MyAdapter.MyItem>(
            MyAdapter.MyItem(false,"Nov.10","Seoul Tour"),
            MyAdapter.MyItem(false,"Nov.11","Gwangjoo Tour"),
            MyAdapter.MyItem(true,"Nov.12","Busan Tour"),
            MyAdapter.MyItem(false,"Nov.13","Choonchun Tour"),
            MyAdapter.MyItem(false,"Nov.14","Inchun Tour"),
        MyAdapter.MyItem(false, "Nov.15","Jeju Tour"),
            MyAdapter.MyItem(false,"Nov.16","Junjoo Tour"),
            MyAdapter.MyItem(false,"Nov.17","End of TOur")
        )

        val sequenceLayout = findViewById<SequenceLayout>(R.id.Seq)

        sequenceLayout.setAdapter(MyAdapter(Items))

    }
}
