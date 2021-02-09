package com.bg.imusicplayer.data.model.obj

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName


data class ImContentType (
    //@Embedded   @SerializedName("im:contentType")val imContentType : ImContentType,
    @Embedded val attributes : Attributes
)