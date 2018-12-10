package com.example.bgg89.travelmaker_project

import com.ramotion.expandingcollection.ECCardData
import java.util.ArrayList
import java.util.Arrays

class CardData(val cardTitle : String,
               private val mainBackgroundResource : Int?,
               private val headBackgroundResource : Int?,
               private val listItems : List<String>
) : ECCardData<String> {
    override fun getMainBackgroundResource(): Int? {
        return mainBackgroundResource
    }

    override fun getHeadBackgroundResource(): Int? {
        return headBackgroundResource
    }

    override fun getListItems(): List<String> {
        return listItems
    }

    companion object {
        fun generateExampleData(): List<ECCardData<*>>{
            var list = ArrayList<ECCardData<*>>()
            list.add(
                    CardData(
                            "Card 1",
                            R.drawable.attractions,
                            R.drawable.attractions_head,
                            createItemList("Card 1")
                    )
            )
            list.add(
                    CardData(
                            "Card 2",
                            R.drawable.city_scape,
                            R.drawable.city_scape_head,
                            createItemList("Card 2")
                    )
            )
            list.add(
                    CardData(
                            "Card 3",
                            R.drawable.nature,
                            R.drawable.nature_head,
                            createItemList("Card 3")
                    )
            )
            return list
        }

        private fun createItemList(cardName : String) : List<String>{
            var list = ArrayList<String>()
            list.addAll(
                    Arrays.asList(
                            "$cardName - Item 1",
                            "$cardName - Item 2",
                            "$cardName - Item 3",
                            "$cardName - Item 4",
                            "$cardName - Item 5",
                            "$cardName - Item 6",
                            "$cardName - Item 7"
                    )
            )
            return list
        }
    }
}
