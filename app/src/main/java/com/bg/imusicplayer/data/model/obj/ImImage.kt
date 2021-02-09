package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded


data class ImImage (
	@ColumnInfo(name = "label_ImImage")
	val label : String="",
	@Embedded val attributes : Attributes
)