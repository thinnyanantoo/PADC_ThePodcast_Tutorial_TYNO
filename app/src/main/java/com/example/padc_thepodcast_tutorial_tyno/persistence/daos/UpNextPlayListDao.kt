package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO

@Dao
interface UpNextPlayListDao {
    @Query("SELECT * FROM podcastUpNextEpisode")
    @ColumnInfo
    fun getAllUpNextPlayList(): LiveData<List<EpisodePlaylistVO>>

    @Query("SELECT * FROM podcastUpNextEpisode WHERE id = :upnextId")
    @ColumnInfo
    fun getUpNextById(upnextId: String): LiveData<EpisodePlaylistVO>

    @Query("DELETE FROM podcastUpNextEpisode")
    @ColumnInfo
    fun deleteAll()

    @Delete
    @ColumnInfo
    fun deleteUpNext(episodePlaylistVO: EpisodePlaylistVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @ColumnInfo
    fun insertUpNextPodCasts(episodePlaylistVO: EpisodePlaylistVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @ColumnInfo
    fun insertAllUpNextPodCast(episodePlaylistVO: List<EpisodePlaylistVO>)
}