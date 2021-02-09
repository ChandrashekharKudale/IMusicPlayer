package com.bg.imusicplayer.data.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.View
import android.widget.SeekBar
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.bg.imusicplayer.R
import com.bg.imusicplayer.data.network.NetworkConnectionInterceptor

/**
 * Created by Balaji Gaikwad on 11/1/21.
 */
class SongDetailsViewModel(val networkConnectionInterceptor: NetworkConnectionInterceptor, application: Application
)  : ViewModel(),MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    private var mContext: Application
     var reSeekBar:ObservableField<SeekBar>

    init {
        mContext = application
         reSeekBar = ObservableField<SeekBar>()
    }


    private lateinit var mediaPlayer: MediaPlayer

    fun playSong(url:String,view :View){
        initMediaPlayer(url,view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun initMediaPlayer(songUrl: String,view :View) {

        try {
            if (this::mediaPlayer.isInitialized && mediaPlayer.isPlaying){
                mediaPlayer.stop()
                 view.setBackgroundResource(R.drawable.ic_play)
            }else{
                mediaPlayer = MediaPlayer()
                view.setBackgroundResource(R.drawable.ic_pause)
            }


                mediaPlayer!!.setOnPreparedListener(this)
                mediaPlayer!!.setOnCompletionListener(this)

                mediaPlayer!!.setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()
                )
            mediaPlayer!!.setDataSource(songUrl)
            mediaPlayer!!.prepare()
        } catch (e: Exception) {
            e.printStackTrace()
        }



    }

    override fun onPrepared(p0: MediaPlayer?) {
       /* startUpdatingCallbackWithPosition()
        if (isReset) isReset = false
        setStatus(PLAYING)*/
        mediaPlayer.start()
        /*playerService.startForeground(
            NOTIFICATION_ID,
            mMusicNotificationManager.createNotification()
        )*/
    }

    override fun onCompletion(p0: MediaPlayer?) {

    }

    // Method to initialize seek bar and audio stats

fun initSeekBar(){


}

}