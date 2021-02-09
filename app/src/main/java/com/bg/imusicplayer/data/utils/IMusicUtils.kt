package com.bg.imusicplayer.data.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object IMusicUtils {

    @JvmStatic
    fun buildSpanned(res: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml(res, Html.FROM_HTML_MODE_LEGACY)
        else
            Html.fromHtml(res)
    }



    fun getSongDuration(milliseconds:String):String {
        var duration="";
        try {
            val minutes = milliseconds.toLong() / 1000 / 60
            val seconds = milliseconds.toLong() / 1000 % 60
            duration="$minutes:$seconds"
        } catch (e: Exception) {

        }

        return duration;

    }

    fun getDayName(dateStr: String):String {
            //"2021-01-07T00:00:00-07:00"
        var day=""
        try {
            val inFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.US)
            var dateArr=dateStr.split("-")
            val date = inFormat.parse(dateArr[0]+"-"+dateArr[1]+"-"+dateArr[2])
            val outFormat = SimpleDateFormat("EEEE MMM yyyy hh:mm", Locale.US)
             day = outFormat.format(date!!)
        }catch (e:Exception){
            e.stackTrace
        }

        return day;
    }



}