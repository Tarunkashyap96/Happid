package com.example.happid.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.happid.RetrofitClient
import com.example.happid.models.UserModel
import com.example.happid.databinding.ActivityCreateProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateProfile : AppCompatActivity() {

    private lateinit var createProfile: ActivityCreateProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createProfile = ActivityCreateProfileBinding.inflate(layoutInflater)
        val view: View = createProfile.root
        setContentView(view)

        createProfile.llButtonSubmit.setOnClickListener {
            val firstName = createProfile.etFirstName.text.toString()
            val lastName = createProfile.etLastName.text.toString()
            val phone = createProfile.etPhone.text.toString()
            val postCode = createProfile.etPost.text.toString()

            if (firstName.isEmpty()) {
                createProfile.etFirstName.requestFocus()
                Toast.makeText(this, "Name is Mandatory.", Toast.LENGTH_SHORT).show()

            }  else if (lastName.isEmpty()) {
                createProfile.etLastName.requestFocus()
                Toast.makeText(this, "Last Name is Mandatory.", Toast.LENGTH_SHORT).show()
            }
            else if (phone.isEmpty()) {
                createProfile.etPhone.requestFocus()
                Toast.makeText(this, "Phone Number is Mandatory.", Toast.LENGTH_SHORT).show()
            }
            else if (postCode.isEmpty()) {
                createProfile.etPost.requestFocus()
                Toast.makeText(this, "Post code is Mandatory.", Toast.LENGTH_SHORT).show()
            }else{
                api(firstName, lastName, phone, postCode)
                createProfile.pbProgress.visibility = View.VISIBLE

            }
        }
    }

    private fun api(firstName: String, lastName: String, phone: String, postCode: String) {
        val user = UserModel(firstName, lastName, phone, postCode)
        RetrofitClient().myApi.createUser(user).enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    val createdUser = response.body()
                    createProfile.pbProgress.visibility = View.GONE
                    Toast.makeText(this@CreateProfile, "User Successfully Created.", Toast.LENGTH_SHORT).show()
                } else {
                    createProfile.pbProgress.visibility = View.GONE
                    Toast.makeText(this@CreateProfile, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                createProfile.pbProgress.visibility = View.GONE
                Toast.makeText(this@CreateProfile, t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}