package com.bg.imusicplayer.data.model.obj

import androidx.room.*
import com.bg.imusicplayer.data.utils.DataConverter
import com.google.gson.annotations.SerializedName


@TypeConverters(
    DataConverter::class)
data class Feed (
    @Embedded   val author : Author,
    @ColumnInfo(name = "entry")
    @TypeConverters val entry : List<Entry>,
    @Embedded  val updated : Updated,
    @Embedded   val rights : Rights,
    @Embedded   val title : Title,
    @Embedded  val icon : Icon,
    @ColumnInfo(name = "link")
    @TypeConverters val link : List<Link>,
    @Embedded   val id : Id
)