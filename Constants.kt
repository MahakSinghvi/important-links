package com.cis.cl.util

import android.content.Context
import android.os.Vibrator
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


object Constants {

    const val PREF_NAME = "pref_weather"
    const val DB_NAME = "weather.db"

    const val WEATHER_IMAGE_BASE = "http://openweathermap.org/img/wn/%s@2x.png"

    const val WEATHER_API = "dec60757a99f4d987ffb0ab9119aa466"

    const val CAMERA_REQUEST = 123
    const val GALLERY_REQUEST = 456
    const val BASE_GAME_IMAGE_URL = "http://178.250.174.238:3000/public/gameimage/"

    fun CharSequence.isValidEmail() =
        !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    fun CharSequence.getImagePath(): String {
        return BASE_GAME_IMAGE_URL + this
    }

    fun Any?.showToast(duration: Int, colorCode: Int, context: Context, view: View) {

        if (this is String?) {
            CustomToast().Show_Toast(context, view, this, colorCode)
            val vibs = context.getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator
            vibs.vibrate(duration.toLong())
        } else {
            val res: Int = this as Int
            CustomToast().Show_Toast(context, view, context.getString(res), colorCode)
            val vibs = context.getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator
            vibs.vibrate(duration.toLong())
        }
    }


    fun isETEmpty(elementVal: EditText): Boolean {
        return elementVal.text.toString().trim { it <= ' ' }.isEmpty()
    }

    fun getETValue(elementVal: EditText): String {
        return elementVal.text.toString().trim { it <= ' ' }
    }

    fun getTVValue(elementVal: TextView): String {
        return elementVal.text.toString().trim { it <= ' ' }
    }


    fun CharSequence.getGames(): ArrayList<String> {
        val options = this.split(",")
        val newOptions = ArrayList<String>()
        for (option in options) {
            if (option.trimStart().trimEnd() != "") {
                newOptions.add(option.trimStart().trimEnd())
            }
        }

        return if (newOptions.size < 25) {
            arrayListOf()
        } else {
            newOptions
        }

    }



}