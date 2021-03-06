package com.example.padc_thepodcast_tutorial_tyno.network

import com.example.padc_thepodcast_tutorial_tyno.data.vos.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object CloudFireStoreApiImpl : FireBaseApi {

    val db = Firebase.firestore
    override fun getRandomPodCast(
        onSuccess: (podcast: List<PodCastDetailVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("podcasts")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check connection")
                } ?: run{
                    val podcastList : MutableList<PodCastDetailVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for(document in result) {
                        val data = document.data
                        val podcast = PodCastDetailVO()
                        podcast.pid = data?.get("id") as String
                        podcast.image = data?.get("image") as String
                        podcast.title = data?.get("title") as String
                        podcast.description = data?.get("description") as String
                        podcast.listennotes_url = data?.get("listennotes_url")as String
                        podcastList.add(podcast)
                    }
                    onSuccess(podcastList)
                }

            }
    }

    override fun getUpNext(
        onSuccess: (podcast: List<LatestEpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("latest_episodes").addSnapshotListener{
            value, error ->
            error?.let {
                onFailure(it.message ?: "Please check connection")
            } ?: run{
                val episodeList : MutableList<LatestEpisodeVO> = arrayListOf()
                val result = value?.documents ?: arrayListOf()

                for(document in result){
                    val data = document.data.convertToLatestEpisodeVO()
                    episodeList.add(data)
                }
                onSuccess(episodeList)
            }
        }
    }

    override fun getGenreList(
        onSuccess: (genre: List<GenereVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("genres").addSnapshotListener { value, error ->
            error?.let {
                onFailure(it.message ?: "Please check connection")
            } ?: run {
                val genreList: MutableList<GenereVO> = arrayListOf()
                val result = value?.documents ?: arrayListOf()

                for (document in result) {
                    val data = document.data.convertToGenerVO()
                    genreList.add(data)
                }
                onSuccess(genreList)
            }
        }
            }

    override fun getEpisodeDetail(
        id: String,
        onSuccess: (episode: PodCastDetailVO) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }
}