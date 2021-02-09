package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded


data class ImArtist (
	@ColumnInfo(name = "label_ImArtist")
	val label : String="",
	@Embedded val attributes : Attributes
)