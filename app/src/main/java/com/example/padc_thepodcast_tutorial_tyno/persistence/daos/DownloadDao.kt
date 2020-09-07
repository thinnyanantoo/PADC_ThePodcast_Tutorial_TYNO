package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.DownloadVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO
import retrofit2.http.GET

@Dao
interface DownloadDao {
    @Query("SELECT * FROM downloadTable")
    fun getAllDownloadedItem():LiveData<List<DownloadVO>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserttoDownload(downloadVO: DownloadVO)

    @Query("SELECT * FROM downloadTable WHERE downloadId = :downloadId")
    fun getdownloadById(downloadId: String): LiveData<DownloadVO>

}