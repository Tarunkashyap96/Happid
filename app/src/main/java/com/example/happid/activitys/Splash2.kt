package com.example.happid.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.happid.databinding.ActivitySplash2Binding

class Splash2 : AppCompatActivity() {

    private lateinit var activitySplash2Binding: ActivitySplash2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplash2Binding = ActivitySplash2Binding.inflate(layoutInflater)
        val view: View = activitySplash2Binding.root
        setContentView(view)

        activitySplash2Binding.llButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}