package com.example.myapplication.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
class TaskModel(
    @PrimaryKey(autoGenerate = true)
    var id_task: Int = 0,

    @ColumnInfo
    var title_task: String,

    @ColumnInfo
    var data_create: Long = 0,

    @ColumnInfo
    var description: String = "",

    @ColumnInfo
    var performed: Boolean = false,

    @ColumnInfo
    var chosen: Boolean = false,

    @ColumnInfo
    var number_list: Int = 0
)

