package com.example.padc_thepodcast_tutorial_tyno.network

import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object RealtimeDatabaseFirebaeApiImpl : FireBaseApi {
    private val database: DatabaseReference = Firebase.database.reference

    override fun getRandomPodCast(
        onSuccess: (podcast: List<PodCastDetailVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("podcasts").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val podcastList = arrayListOf<PodCastDetailVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(PodCastDetailVO::class.java)?.let {
                        podcastList.add(it)
                    }
                }
                    onSuccess(podcastList)
            }
        })

    }

    override fun getUpNext(
        onSuccess: (podcast: List<LatestEpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("latest_episodes").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val podcastList = arrayListOf<LatestEpisodeVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(LatestEpisodeVO::class.java)?.let {
                        podcastList.add(it)
                    }
                }
                onSuccess(podcastList)
            }
        })

    }

    override fun getGenreList(
        onSuccess: (genre: List<GenereVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("genres").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val genreList = arrayListOf<GenereVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(GenereVO::class.java)?.let {
                        genreList.add(it)
                    }
                }
                onSuccess(genreList)
            }
        })
    }

    override fun getEpisodeDetail(
        id : String,onSuccess: (episode: PodCastDetailVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("podcasts").child(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val episodeList = arrayListOf<PodCastDetailVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(PodCastDetailVO::class.java)?.let {
                        onSuccess(it)
                    }

                }

            }
        })
    }
}
