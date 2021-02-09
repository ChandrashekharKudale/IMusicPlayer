package com.bg.imusicplayer.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bg.imusicplayer.data.model.obj.MusicFeed
import com.bg.imusicplayer.data.model.repository.MusicListRepository
import com.bg.imusicplayer.data.network.NetworkConnectionInterceptor


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SongListViewModel(val
    repository: MusicListRepository,
                        val  networkConnectionInterceptor: NetworkConnectionInterceptor
) : ViewModel() {

    suspend fun getSongInfo(limit:Int): MutableLiveData<MusicFeed> {

        return withContext(Dispatchers.IO) {

            repository.fetchTopMusicFeed(limit)
        }
    }

    suspend fun getOfflineSongs() = withContext(Dispatchers.IO) { repository.getOfflineSongs() }
}