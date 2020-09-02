package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO

@Dao
interface EpisodeDetailDao {
    @Query("SELECT * FROM detailTable")
    fun getEpisodes(): LiveData<List<EpisodeDetailVO>>

    @Query("SELECT * FROM detailTable WHERE id = :episodeId")
    fun getEpisodeById(episodeId: String): LiveData<EpisodeDetailVO>

    @Query("DELETE FROM detailTable")
    fun deleteAll()

    @Delete
    fun deleteEpisode(episodeDetailVO: EpisodeDetailVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(episodeDetailVO: EpisodeDetailVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDetail(episodeDetailVO: List<EpisodeDetailVO>)
}