package com.bg.imusicplayer.data.db

import com.bg.imusicplayer.data.model.obj.MusicFeed
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bg.imusicplayer.data.utils.DataConverter


/**
 * Created by Balaji Gaikwad on 10/01/21.
 */

@Database(
    entities = [MusicFeed::class],
    version = 1, exportSchema = false)
@TypeConverters(
    DataConverter::class)

abstract class IMusicDataBase :RoomDatabase() {

   //
    abstract fun getMusicDao(): MusicDao


    companion object {

        @Volatile
        private var instance: IMusicDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                IMusicDataBase::class.java,
                "IMusicDataBase.db"
            ).build()
    }
}