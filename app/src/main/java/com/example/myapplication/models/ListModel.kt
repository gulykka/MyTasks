package com.example.myapplication.models

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "list_table")
class ListModel (
    @PrimaryKey(autoGenerate = true)
    var id_list: Int = 0,

    @ColumnInfo
    var title_list: String

): Serializable