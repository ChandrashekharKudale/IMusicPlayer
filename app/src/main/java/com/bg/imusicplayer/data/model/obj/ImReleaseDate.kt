package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded


data class ImReleaseDate (

	@ColumnInfo(name = "label_ImReleaseDate")
	val label : String="",
	@Embedded val attributes : Attributes
)