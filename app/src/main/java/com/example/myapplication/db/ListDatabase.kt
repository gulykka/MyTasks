package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.db.dao.ListDao
import com.example.myapplication.models.ListModel


@Database(entities = [ListModel::class], version = 1)
abstract class ListDatabase: RoomDatabase() {

    abstract fun getListDao(): ListDao

    companion object{
        private var database: ListDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): ListDatabase {
            return if (database == null){
                database = Room.databaseBuilder(context, ListDatabase::class.java, "db1").build()
                database as ListDatabase
            }else{
                database as ListDatabase
            }
        }
    }
}
