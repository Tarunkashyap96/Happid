package com.example.happid.activitys

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.happid.R
import com.example.happid.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view: View = loginBinding.root
        setContentView(view)

        loginBinding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        loginBinding.llOtpButton.setOnClickListener {
            val countryCode: String =  loginBinding.countryCode.selectedCountryCode
            val phoneNo = loginBinding.etPhoneNumber.text.toString()
            if (phoneNo.length < 10) {
                Toast.makeText(this, "In-valid Phone Number", Toast.LENGTH_SHORT).show()
            } else {
                val startTwoDigits = phoneNo.substring(0, 2)
                val endTwoDigits = phoneNo.substring(phoneNo.length - 2)
                otp(startTwoDigits, endTwoDigits, phoneNo, countryCode)
            }
        }
    }


    private fun otp(a: String, endTwoDigits: String, phoneNo: String, countryCode: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.otp_dialog)
        dialog.setCancelable(true)

        val otpText = dialog.findViewById<TextView>(R.id.txOTP)
        val otp = a + endTwoDigits
        otpText.text = otp

        dialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, OTP::class.java)
            intent.putExtra("phoneNo", "+$countryCode $phoneNo")
            intent.putExtra("otp", otp)
            startActivity(intent)
            dialog.dismiss()
        }, 2000)

    }

}