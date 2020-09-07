package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO


@Dao
interface GenereDao {
    @Query("SELECT * FROM genereTable")
    fun getAllGenere(): LiveData<List<GenereVO>>

    @Query("SELECT * FROM genereTable WHERE id = :genreId")
    fun getGeneretById(genreId: String): LiveData<GenereVO>

    @Query("DELETE FROM genereTable")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenere(genereVO: GenereVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenere(genereVO: List<GenereVO>)
}