package com.example.rss.data.source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rss.domain.model.xmlFeed.DetailModel
import io.reactivex.Flowable

@Dao
interface XmlFeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertXmlFeed(xmlFeed: List<DetailModel>): List<Long>

    @Query("SELECT COUNT(*) FROM xmlFeed")
    fun getCount(): Int

    @Query("SELECT * FROM xmlFeed")
    fun getXmlFeed(): Flowable<List<DetailModel>>

    @Query("UPDATE xmlFeed SET isFavorite=1 WHERE guid =:id")
    fun favoriteXmlFeed(id: String)

    @Query("UPDATE xmlFeed SET isFavorite=0 WHERE guid =:id")
    fun unFavoriteXmlFeed(id: String)

    @Query("SELECT * FROM xmlFeed WHERE isFavorite=1")
    fun getFavoriteXmlFeed(): Flowable<List<DetailModel>>

    @Query("SELECT * FROM xmlFeed WHERE guid=:id")
    fun findNewsFaById(id: String): DetailModel?

}