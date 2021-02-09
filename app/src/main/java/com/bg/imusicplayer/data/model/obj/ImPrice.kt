package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class ImPrice (

	@ColumnInfo(name = "label_ImPrice")
	val label : String="",
	@Embedded val attributes : Attributes
)