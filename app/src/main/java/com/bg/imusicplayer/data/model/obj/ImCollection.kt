package com.bg.imusicplayer.data.model.obj

import com.google.gson.annotations.SerializedName

data class ImCollection (

    @SerializedName("im:name") val  name: ImName,
    val link : Link,
    @SerializedName("im:contentType")val contentType : ImContentType
)