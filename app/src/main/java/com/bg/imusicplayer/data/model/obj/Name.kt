package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class Name (
	@ColumnInfo(name = "label_Name")
	 val label : String=""
)