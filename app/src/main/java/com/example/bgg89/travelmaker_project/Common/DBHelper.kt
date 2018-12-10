//package com.example.bgg89.travelmaker_project.Common
//
//import android.content.ContentValues
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
///**
// * Created by bgg89 on 2018-12-09.
// */
//
//class DBHelper(context: Context, name: String?,
//                      factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
//
//    private val mDbHelper: DBHelper? = null
//    // All Static variables
//    private val DATABASE_PATH: String? = null
//    // Database Version
//    private val DATABASE_VERSION = 1
//
//    // Database Name
//    private val DATABASE_NAME = "TREVEL"
//
//    // Contacts table name
//    private val TRAVEL_LIST = "travel_list"
//    private val SCHEDULE_LIST = "schedule_list"
//    private val PAYMENT_LIST = "payment_list"
//    private val db: SQLiteDatabase? = null
//
//    // Contacts Table Columns names
//
//    override fun onCreate(db: SQLiteDatabase) {
//
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS)
//        onCreate(db)
//    }
//
//    companion object {
//        private val DATABASE_VERSION = 1
//        private val DATABASE_NAME = "productDB.db"
//        val TABLE_PRODUCTS = "products"
//
//        val COLUMN_ID = "_id"
//        val COLUMN_PRODUCTNAME = "productname"
//        val COLUMN_QUANTITY = "quantity"
//    }
//
//    fun addProduct(product: Product) {
//        val values = ContentValues()
//        values.put(COLUMN_PRODUCTNAME, product.productName)
//        values.put(COLUMN_QUANTITY, product.quantity)
//
//        val db = this.writableDatabase
//
//        db.insert(TABLE_PRODUCTS, null, values)
//        db.close()
//    }﻿
//
//    fun findProduct(productname: String): Product? {
//        val query = "SELECT * FROM $TABLE_PRODUCTS WHERE $COLUMN_PRODUCTNAME =  \"$productname\""
//        val db = this.writableDatabase
//        val cursor = db.rawQuery(query, null)
//        var product: Product? = null
//
//        if (cursor.moveToFirst()) {
//            cursor.moveToFirst()
//
//            val id = Integer.parseInt(cursor.getString(0))
//            val name = cursor.getString(1)
//            val quantity = Integer.parseInt(cursor.getString(2))
//            product = Product(id, name, quantity)
//            cursor.close()
//        }
//
//        db.close()
//        return product
//    }﻿
//
//    fun deleteProduct(productname: String): Boolean {
//        var result = false
//        val query = "SELECT * FROM $TABLE_PRODUCTS WHERE $COLUMN_PRODUCTNAME = \"$productname\""
//        val db = this.writableDatabase
//        val cursor = db.rawQuery(query, null)
//
//        if (cursor.moveToFirst()) {
//            val id = Integer.parseInt(cursor.getString(0))
//            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
//                    arrayOf(id.toString()))
//            cursor.close()
//            result = true
//        }
//        db.close()
//        return result
//    }﻿
//}﻿