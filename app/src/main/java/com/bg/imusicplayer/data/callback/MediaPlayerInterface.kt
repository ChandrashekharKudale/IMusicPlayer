package com.bg.imusicplayer.data.callback

/**
 * Created by Balaji Gaikwad on 11/1/21.
 */
interface MediaPlayerInterface {
    fun onPositionChanged(position: Int)
    fun onStateChanged()
    fun onPlaybackCompleted()
    fun onClose()
}