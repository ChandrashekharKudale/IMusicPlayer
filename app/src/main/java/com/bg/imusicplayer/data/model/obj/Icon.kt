package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class Icon (
	@ColumnInfo(name = "label_Icon")
	 val label : String
)