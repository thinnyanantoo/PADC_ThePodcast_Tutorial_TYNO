package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO

@Dao
interface RandomPodCastDao {

    @Query("SELECT * FROM randomPodCast")
    fun getAllRandomPodCast(): LiveData<RandomPodCastVO>

    @Query("SELECT * FROM randomPodCast WHERE id = :podcastId")
    fun getRandomPodCastById(podcastId: Int): LiveData<RandomPodCastVO>

    @Query("DELETE FROM randomPodCast")
    fun deleteAll()

    @Delete
    fun deleteRandomPodCasts(randomPodCastVO: RandomPodCastVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRandomPodCasts(podCastVO: RandomPodCastVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRandomPodCasts(podCastVO: RandomPodCastVO)
}