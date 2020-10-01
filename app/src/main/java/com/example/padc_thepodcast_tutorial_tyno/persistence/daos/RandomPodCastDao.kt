package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.LatestEpisodeVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.PodCastDetailVO

@Dao
interface RandomPodCastDao {

    @Query("SELECT * FROM randomPodCast")
    fun getAllRandomPodCast(): LiveData<PodCastDetailVO>

    @Query("SELECT * FROM randomPodCast WHERE pid = :podcastId")
    fun getRandomPodCastById(podcastId: String): LiveData<PodCastDetailVO>

    @Query("DELETE FROM randomPodCast")
    fun deleteAll()

    @Delete
    fun deleteRandomPodCasts(latestEpisodeVO: PodCastDetailVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRandomPodCasts(podCastVO: PodCastDetailVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRandomPodCasts(podCastVO: List<PodCastDetailVO>)
}