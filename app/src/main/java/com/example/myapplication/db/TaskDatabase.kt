package com.example.myapplication.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.db.dao.ListDao
import com.example.myapplication.db.dao.TaskDao
import com.example.myapplication.models.ListModel
import com.example.myapplication.models.TaskModel


@Database(entities = [TaskModel::class, ListModel::class], version = 1)
abstract class TasksDatabase: RoomDatabase() {

    abstract fun getTaskDao(): TaskDao
    abstract fun getListDao(): ListDao

    companion object{
        private var database: TasksDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): TasksDatabase {
            return if (database == null){
                database = Room.databaseBuilder(context, TasksDatabase::class.java, "db")
                    .fallbackToDestructiveMigration()
                    .build()
                database as TasksDatabase
            }else{
                database as TasksDatabase
            }
            }
        }
    }
