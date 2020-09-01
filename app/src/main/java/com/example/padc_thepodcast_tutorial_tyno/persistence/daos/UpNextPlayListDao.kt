package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO

@Dao
interface UpNextPlayListDao {
    @Query("SELECT * FROM podcastUpNextEpisode")
    fun getAllUpNextPlayList(): LiveData<List<EpisodePlaylistVO>>

    @Query("SELECT * FROM podcastUpNextEpisode WHERE id = :upnextId")
    fun getUpNextById(upnextId: Int): LiveData<EpisodePlaylistVO>

    @Query("DELETE FROM podcastUpNextEpisode")
    fun deleteAll()

    @Delete
    fun deleteUpNext(episodePlaylistVO: EpisodePlaylistVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUpNextPodCasts(episodePlaylistVO: EpisodePlaylistVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUpNextPodCast(episodePlaylistVO: List<EpisodePlaylistVO>)
}