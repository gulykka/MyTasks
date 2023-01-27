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
    fun onClick(view: View?) {
        val intent = Intent(this, NewTask::class.java)
        startActivity(intent)
    }


//
//    newlist_button.setOnClickListener {
//        val intent = Intent(this, NewTask::class.java)
//        startActivity(intent)
//    }
////    fun showDialog(v: View?) {
//        val dialog = CustomDialogFragment()
//        dialog.show(supportFragmentManager, "custom")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.e("AAA","Destroy")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.e("AAA","Stop")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.e("AAA", "Pause")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.e("AAA", "Resume")
//    }



}