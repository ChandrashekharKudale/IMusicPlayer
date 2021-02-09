package com.bg.imusicplayer.data.db

import com.bg.imusicplayer.data.model.obj.MusicFeed
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Balaji Gaikwad on 10/01/21.
 */
@Dao
interface MusicDao {

    @Query("SELECT * FROM MusicFeed")
    fun getOfflineTopSongs() : LiveData<MusicFeed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopSongInfo(ResultsItem : MusicFeed)
}