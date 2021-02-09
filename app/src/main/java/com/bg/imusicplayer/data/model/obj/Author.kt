package com.bg.imusicplayer.data.model.obj

import androidx.room.Embedded

data class Author (

    @Embedded val name : Name,
    @Embedded  val uri : Uri
)