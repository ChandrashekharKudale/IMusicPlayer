package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class Updated (
	@ColumnInfo(name = "label_Updated")
	 val label : String=""
)