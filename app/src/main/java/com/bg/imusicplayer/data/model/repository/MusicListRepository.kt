package com.bg.imusicplayer.data.model.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bg.imusicplayer.data.db.IMusicDataBase
import com.bg.imusicplayer.data.model.obj.MusicFeed
import com.bg.imusicplayer.data.network.AbstractTaskApiRequest
import com.bg.imusicplayer.data.network.ApiEndPoint
import com.bg.imusicplayer.data.utils.Coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Balaji Gaikwad on 12/01/21.
 */
class MusicListRepository (val apiEndPoint: ApiEndPoint, val db: IMusicDataBase) : AbstractTaskApiRequest(){

    private val musicFeedLiveData = MutableLiveData<MusicFeed>()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    suspend fun fetchTopMusicFeed(limit: Int): MutableLiveData<MusicFeed> {
        return withContext(Dispatchers.IO) {
            var   response = apiRequest { apiEndPoint.fetchTopSongs(limit) }
            musicFeedLiveData.postValue(response)
            saveTopSongsInfo(response)
            musicFeedLiveData
        }
    }


    fun saveTopSongsInfo(resultsItem: MusicFeed) {
        Coroutines.io {
            db.getMusicDao().saveTopSongInfo(resultsItem)
        }
    }

    suspend fun getOfflineSongs(): LiveData<MusicFeed> {
        return withContext(Dispatchers.IO) {
            db.getMusicDao().getOfflineTopSongs()
        }
    }


}