package com.bg.imusicplayer.data.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bg.imusicplayer.data.model.repository.MusicListRepository
import com.bg.imusicplayer.data.network.NetworkConnectionInterceptor


/**
 * Created by Balaji Gaikwad on 10/01/21.
 */
class SongListViewModelFactory (private val repository: MusicListRepository,val networkConnectionInterceptor: NetworkConnectionInterceptor) : ViewModelProvider.NewInstanceFactory() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SongListViewModel(repository,networkConnectionInterceptor) as T
    }
}