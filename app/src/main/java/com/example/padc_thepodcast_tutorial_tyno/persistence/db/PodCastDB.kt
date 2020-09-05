package com.example.padc_thepodcast_tutorial_tyno.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodeDetailVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.EpisodePlaylistVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.GenereVO
import com.example.padc_thepodcast_tutorial_tyno.data.vos.RandomPodCastVO
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.GenreTypeConverter
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.PodCastTypeConverter
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.EpisodeDetailDao
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.GenereDao
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.RandomPodCastDao
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.UpNextPlayListDao

@Database(
    entities = [RandomPodCastVO::class, EpisodePlaylistVO::class, EpisodeDetailVO::class, GenereVO::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(PodCastTypeConverter::class,GenreTypeConverter::class)
abstract class PodCastDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PodCastDB"
        var dbInstance: PodCastDB? = null

        fun getDBInstance(context: Context): PodCastDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(
                        context, PodCastDB::class.java, DB_NAME
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun RandomPodCastDao(): RandomPodCastDao
    abstract fun UpNextPlayListDao(): UpNextPlayListDao
    abstract fun EpisodeDetailDao(): EpisodeDetailDao
    abstract fun GenereDao(): GenereDao
}