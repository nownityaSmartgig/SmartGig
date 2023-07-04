package com.smartgig.tech.ui.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivityLoginBinding
import com.smartgig.tech.util.SharedPreferenceUtil

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        sharedPreferenceUtil = SharedPreferenceUtil.getInstance(this)

        if (sharedPreferenceUtil.getIsLoggedIn()) {
            navigateToactivity()
            finish() // Finish LoginActivity so user can't go back to it using back button
            return
        }

        //Login Button Function

        val savedUsername = sharedPreferenceUtil.getSavedUsername()
        val savedPassword = sharedPreferenceUtil.getSavedPassword()

        if (savedUsername != null && savedPassword != null) {
            binding.etEmail.setText(savedUsername)
            binding.etPassword.setText(savedPassword)
        }

        binding.btLogin.setOnClickListener {

            navigateToactivity()
//            val username = binding.etEmail.text.toString()
//            val password = binding.etPassword.text.toString()
//
//            if (validateLogin(username, password)) {
//                saveLoginStatus(username, password, true)
//                navigateToactivity()
//            } else {
//                Toast.makeText(this, "Wrong email or password", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    private fun validateLogin(username:String,password:String):Boolean{
        return username == "admin" && password == "password"
    }

    private fun saveLoginStatus(username: String, password: String, isLoggedIn: Boolean) {
        sharedPreferenceUtil.saveLoginData(username, password, isLoggedIn)
    }

    private fun navigateToactivity() {
        val intent = Intent(this, SuperAdminActivity::class.java)
        startActivity(intent)
        finish()
    }

}