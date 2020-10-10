package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO

@Dao
interface EpisodeDetailDao {
    @Query("SELECT * FROM detailTable")
    fun getEpisodes(): LiveData<List<LatestEpisodeVO>>

    @Query("SELECT * FROM detailTable ORDER BY RANDOM() LIMIT 1")
    fun getRandomEpisode() : LiveData<LatestEpisodeVO>
    //fun getRandomEpisode()

    @Query("SELECT * FROM detailTable WHERE id = :episodeId")
    fun getEpisodeById(episodeId: String): LiveData<LatestEpisodeVO>

    @Query("DELETE FROM detailTable")
    fun deleteAll()

    @Delete
    fun deleteEpisode(episodeDetailVO: LatestEpisodeVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(episodeDetailVO: LatestEpisodeVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDetail(episodeDetailVO: List<LatestEpisodeVO>)
}