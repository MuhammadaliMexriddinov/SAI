package uz.alpha.stresometr.data.local

import android.content.Context
import android.content.SharedPreferences
import android.hardware.biometrics.BiometricManager
import uz.alpha.stresometr.app.App


/**
Mobile Developer
Creator:Mekhriddinov Muhammadali
 */
class SharedPref private constructor() {

    private val preferences: SharedPreferences =
        App.context!!.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)


    companion object {
        private lateinit var myPref: SharedPref

        fun getInstance(): SharedPref {
            if (!this::myPref.isInitialized) {
                myPref = SharedPref()
            }
            return myPref
        }
    }



    fun setName(s: String) {
        preferences.edit().putString("SET", s).apply()
    }

    fun getName() = preferences.getString("SET", " ")

    fun setImage(s: String) {
        preferences.edit().putString("SET1", s).apply()
    }

    fun getImage() = preferences.getString("SET1", " ")


    var language: String?
        get() = preferences.getString("language", "eng")
        set(language) {
            preferences.edit().putString("language", language).apply()
        }

}