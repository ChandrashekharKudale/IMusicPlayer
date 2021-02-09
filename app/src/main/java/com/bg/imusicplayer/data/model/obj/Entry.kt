package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.TypeConverters
import com.bg.imusicplayer.data.utils.DataConverter
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@TypeConverters(
    DataConverter::class)
data class Entry (
    val category: Category,
    val id: Id,
    @Embedded  @SerializedName("im:artist")val artist: ImArtist,
    @Embedded   @SerializedName  ("im:collection") val collection: ImCollection,
    @Embedded    @SerializedName  ("im:contentType") val contentType: ImContentType,

    @SerializedName  ("im:image")
    @ColumnInfo(name = "image")
    @TypeConverters val image : List<ImImage>,
    @Embedded  @SerializedName  ("im:name") val name: ImName,
    @Embedded   @SerializedName  ("im:price") val price: ImPrice,
    @Embedded   @SerializedName  ("im:releaseDate") val releaseDate: ImReleaseDate,


    @ColumnInfo(name = "link")
    @TypeConverters val link : List<Link>,
    @Embedded  val rights: Rights,
    @Embedded  val title: Title



) : Serializable