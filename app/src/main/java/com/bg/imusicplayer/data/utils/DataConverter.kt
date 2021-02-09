package com.bg.imusicplayer.data.utils

import androidx.room.TypeConverter
import com.bg.imusicplayer.data.model.obj.Entry
import com.bg.imusicplayer.data.model.obj.ImImage
import com.bg.imusicplayer.data.model.obj.Link
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * Created by Balaji Gaikwad on 10/1/21.
 */
class DataConverter {

    @TypeConverter
    fun listFeedToJson(value: List<Entry>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToFeed(value: String) = Gson().fromJson(value, Array<Entry>::class.java).toList()



    @TypeConverter
    fun listImImageToJson(value: List<ImImage>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToImImage(value: String) = Gson().fromJson(value, Array<ImImage>::class.java).toList()



    @TypeConverter
    fun listLinkToJson(value: List<Link>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListLink(value: String) = Gson().fromJson(value, Array<Link>::class.java).toList()

}