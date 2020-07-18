package com.example.rss.data.source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rss.domain.model.xmlFeed.DetailModel
import io.reactivex.Flowable

@Dao
interface XmlFeedDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertXmlFeed(details: List<DetailModel>): List<Long>

    /*@Query("SELECT * FROM xmlFeed WHERE isFavorite=1")
    fun getFavoriteNewsFa(xmlFeed: String): Flowable<List<DetailModel>>

    @Query("SELECT * FROM xmlFeed WHERE guid=:id")
    fun findNewsFaById(id: String): Flowable<DetailModel>*/
}