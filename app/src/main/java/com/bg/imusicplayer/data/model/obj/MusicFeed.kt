package com.bg.imusicplayer.data.model.obj

import androidx.room.*
import com.bg.imusicplayer.data.utils.DataConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "MusicFeed")
@TypeConverters(
	DataConverter::class)
data class MusicFeed (
	@PrimaryKey(autoGenerate = true) val ids :Int,
	@Embedded
	val feed : Feed
)