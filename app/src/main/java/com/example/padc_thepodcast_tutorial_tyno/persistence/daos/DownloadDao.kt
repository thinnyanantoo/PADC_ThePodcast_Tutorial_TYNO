package com.example.padc_thepodcast_tutorial_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.padc_thepodcast_tutorial_tyno.data.vos.UpNextPlayListVO

@Dao
interface DownloadDao {
    @Query("SELECT * FROM UPNEXTTABLE")
    fun getAllDownloadedItem():LiveData<List<UpNextPlayListVO>>

    @Delete
    fun deleteEpisode(upnextplaylistVO: UpNextPlayListVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserttoDownload(upnextplaylistVO: UpNextPlayListVO)

}