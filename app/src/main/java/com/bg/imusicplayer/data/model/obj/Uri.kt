package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded


data class Uri (
	@ColumnInfo(name = "label_Uri")
	 val label : String=""
)