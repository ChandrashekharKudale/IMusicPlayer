package com.bg.imusicplayer.data.model.obj

import androidx.room.Embedded

data class Category (

	@Embedded val attributes : Attributes
)