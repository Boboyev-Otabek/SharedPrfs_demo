package com.example.sharedprfs.managers

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(var context: Context) {


    lateinit var sharedPreferences: SharedPreferences

    companion object {
        var prefsManager: PrefsManager? = null
        fun getInstance(context: Context): PrefsManager {
            if (prefsManager == null) {
                prefsManager = PrefsManager(context)
            }
            return prefsManager as PrefsManager
        }
    }


    init {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    fun savedata(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).commit()

    }

    fun loaddata(key: String): String {
        return if (sharedPreferences != null) sharedPreferences.getString(key, "not data")!!
        else ""
    }
}