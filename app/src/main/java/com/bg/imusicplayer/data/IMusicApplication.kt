package com.bg.imusicplayer.data

import android.app.Application
import com.bg.imusicplayer.data.db.IMusicDataBase
import com.bg.imusicplayer.data.model.repository.MusicListRepository
import com.bg.imusicplayer.data.network.ApiEndPoint
import com.bg.imusicplayer.data.network.NetworkConnectionInterceptor
import com.bg.imusicplayer.data.viewmodel.SongDetailsViewModelFactory
import com.bg.imusicplayer.data.viewmodel.SongListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Balaji Gaikwad on 11/1/21.
 */
class IMusicApplication :Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@IMusicApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiEndPoint(instance()) }

        bind() from singleton { MusicListRepository(instance(),instance()) }
        //bind() from singleton { MusicPlayerService() }
        bind() from singleton { IMusicDataBase(instance()) }
        bind() from provider { SongListViewModelFactory(instance(),instance()) }
        bind() from provider { SongDetailsViewModelFactory(instance(),instance()) }

    }
}