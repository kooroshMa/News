package com.example.rss.data.source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rss.domain.model.xmlFeed.DetailModel
import com.example.rss.domain.model.xmlFeed.XmlFeedModel
import io.reactivex.Flowable

@Dao
interface XmlFeedDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertXmlFeed(xmlFeed: List<DetailModel>): List<Long>

    @Query("SELECT COUNT(*) FROM xmlFeed")
    fun getCount(): Int

    @Query("SELECT * FROM xmlFeed")
    fun getXmlFeed(): Flowable<List<DetailModel>>

   /* @Query("SELECT * FROM xmlFeed WHERE isFavorite=1")
    fun getFavoriteXmlFeed(xmlFeed: String): Flowable<List<DetailModel>>

    @Query("SELECT * FROM xmlFeed WHERE guid=:id")
    fun findXmlFeedById(id: String): Flowable<DetailModel>*/

}