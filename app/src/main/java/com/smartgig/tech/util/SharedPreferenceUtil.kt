package com.smartgig.tech.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceUtil private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveLoginData(username: String, password: String, isLoggedIn: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_USERNAME, username)
        editor.putString(KEY_PASSWORD, password)
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.apply()
    }

    fun getSavedUsername(): String? {
        return sharedPreferences.getString(KEY_USERNAME, null)
    }

    fun getSavedPassword(): String? {
        return sharedPreferences.getString(KEY_PASSWORD, null)
    }

    fun getIsLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    companion object {
        private const val PREF_NAME = "LoginPrefs"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"

        @Volatile
        private var instance: SharedPreferenceUtil? = null

        fun getInstance(context: Context): SharedPreferenceUtil {
            return instance ?: synchronized(this) {
                instance ?: SharedPreferenceUtil(context.applicationContext).also { instance = it }
            }
        }
    }
}
