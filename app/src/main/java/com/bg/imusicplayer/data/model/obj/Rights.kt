package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded


data class Rights (
	@ColumnInfo(name = "label_Rights")
	 val label : String=""
)