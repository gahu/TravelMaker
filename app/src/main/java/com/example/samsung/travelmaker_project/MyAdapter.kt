package com.example.samsung.travelmaker_project

import com.transferwise.sequencelayout.SequenceAdapter
import com.transferwise.sequencelayout.SequenceStep

class MyAdapter (val items : List<MyItem>) : SequenceAdapter<MyAdapter.MyItem>() {

    override fun bindView(sequenceStep: SequenceStep, item: MyItem) {

        // item view 를 어떻게 그릴 것인지를 전달
        // item view 는 각각의 step view 를 지칭

        with(sequenceStep) {
            // sequenceStep 을 인자로 전달 받음
            // 블록 내부는 sequenceStep 이 중심 객체가 됨
            // 그리고 결과 sequenceStep 을 반환

            setActive(item.isActive)   // 해당 step view 가 작동을 할 것인가?? (pulse 효과의 유무
            setAnchor(item.formattedDate) //  anchor : pulse 애니메이션의 왼쪽 부분의 텍스트를 지정
            setAnchorTextAppearance(R.style.TextAppearance_AppCompat_Title) // 텍스트의 스타일 지정
            setTitle(item.title) // pulse 애니메이션 왼쪽의 타이틀 텍스트 설정
            setTitleTextAppearance(R.style.TextAppearance_AppCompat_Title) // 타이틀 텍스트의 스타일을 지정
            setSubtitle(R.string.Testing_Sub) // 서브 텍스트 (pulse 애니메이션이 active 일 때만 표시)
            setSubtitleTextAppearance(R.style.TextAppearance_AppCompat_Title) // 서브 텍스트의 스타일 지정

            // Listener 등록 (onClick Listener, onLongClick Listener)
            //  : onClick Listener : 효과 취소
            //  : onLongClick LIstener : 효과 취소

        }
    }

    override fun getCount(): Int {

        // 몇 개의 item view 를 그릴지 전달

        return items.size
    }

    override fun getItem(position: Int): MyItem {

        // 해당 item view 를 몇번 째 data 로 채울 것인가??

        return  items[position]
    }


    data class MyItem(val isActive : Boolean, val formattedDate : String, val title :String) {
        // 데이터 클래스 : 단순히 데이터 저장을 위한 용도로만 사용 (MyAdapter 내부에서만 사용)
    }
}