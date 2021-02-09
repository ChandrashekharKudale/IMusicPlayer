package com.bg.imusicplayer.data.viewmodel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bg.imusicplayer.data.network.NetworkConnectionInterceptor
import java.lang.Appendable


/**
 * Created by Balaji Gaikwad on 10/1/21.
 */

class SongDetailsViewModelFactory(val networkConnectionInterceptor: NetworkConnectionInterceptor,val application: Application) : ViewModelProvider.NewInstanceFactory() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SongDetailsViewModel(networkConnectionInterceptor,application) as T
    }
}