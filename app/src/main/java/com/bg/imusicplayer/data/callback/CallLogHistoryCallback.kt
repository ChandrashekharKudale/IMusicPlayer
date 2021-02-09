package com.bg.callhistory.callback

import com.bg.imusicplayer.data.model.obj.Entry


interface MusicCallback {
    fun onClick(transaction: Entry)
}