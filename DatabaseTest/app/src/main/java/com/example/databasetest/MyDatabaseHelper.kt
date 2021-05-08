package com.example.databasetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class MyDatabaseHelper(val context: Context, name: String, version: Int):
SQLiteOpenHelper(context, name, null, version){

    private val createBook = "create table Book (" +
            " id integer primary key autoincrement, " +
            "author text, " +
            "price real, " 
            "pages integer, " +
            "name text, " +
            "category_id integer)"

    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement, " +
            "category_name text, " +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)
        db?.execSQL(createCategory)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Book")
        db?.execSQL("drop table if exists Category")
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("MyDataHelper", "Downgrade from $oldVersion to $newVersion")
        super.onDowngrade(db, oldVersion, newVersion)
    }
}