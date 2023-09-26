package com.example.happid.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.happid.databinding.ActivityOtpBinding

class OTP : AppCompatActivity() {

    private lateinit var otpBinding: ActivityOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        otpBinding = ActivityOtpBinding.inflate(layoutInflater)
        val view: View = otpBinding.root
        setContentView(view)

        val phoneNo: String = intent.getStringExtra("phoneNo").toString()
        val otp: String = intent.getStringExtra("otp").toString()

        otpBinding.txPhoneNumber.text = phoneNo

        otpBinding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        otpBinding.editPhone.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        otpBinding.llOtpSubmit.setOnClickListener {
            val inputOtp = otpBinding.pinview.text.toString()
            if (inputOtp == otp) {
                val intent = Intent(this, CreateProfile::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "In-Correct OTP!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}