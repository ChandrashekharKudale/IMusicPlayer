package com.bg.imusicplayer.data.model.obj

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


data class Link (
	@Embedded    @SerializedName("im:duration") val duration: SongDuration,
	@Embedded val attributes : Attributes
)