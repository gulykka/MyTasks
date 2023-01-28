package com.example.myapplication


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class NewTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_task)
    }
    fun closeNewTask(view: View?) {
        finish()
    }
}