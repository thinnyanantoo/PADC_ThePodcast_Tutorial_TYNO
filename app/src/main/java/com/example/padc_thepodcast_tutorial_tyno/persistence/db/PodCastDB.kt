package com.example.padc_thepodcast_tutorial_tyno.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.example.padc_thepodcast_tutorial_tyno.persistence.TypeConverters.*
import com.example.padc_thepodcast_tutorial_tyno.persistence.daos.*

@Database(
    entities = [RandomPodCastVO::class, EpisodePlaylistVO::class, EpisodeDetailVO::class, GenereVO::class,UpNextPlayListVO::class,DownloadVO::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(PodCastTypeConverter::class,PodCastDetialVOTypeConverter::class,
    UpNextPlayListTypeConverters::class,ExtraVoTypeConverters::class,
    GenreTypeConverter::class,
    LookingForTypeConverters::class)
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
    abstract fun downloadDao(): DownloadDao
}