package com.bg.imusicplayer.data.model.obj

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class Title (
	@ColumnInfo(name = "label_Title")
	 val label : String=""
)