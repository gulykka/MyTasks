package com.example.myapplication;
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.general_page)
        }
    fun openAddList(view: View?) {
        val intent = Intent(this, NewListTasks::class.java)
        startActivity(intent)
    }
    fun openAddTask(view: View?) {
        val intent = Intent(this, NewTask::class.java)
        startActivity(intent)
    }


}