package com.example.myapplication.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "list_table")
class ListModel {
    @PrimaryKey(autoGenerate = true)
    var id_list: Int = 0

    @ColumnInfo
    var title_list: String = ""

}