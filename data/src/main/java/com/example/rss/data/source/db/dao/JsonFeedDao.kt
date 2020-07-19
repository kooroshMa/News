package com.example.rss.data.source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rss.domain.model.jsonFeed.ArticleModel
import io.reactivex.Flowable

@Dao
interface JsonFeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJsonFeed(jsonFeed: List<ArticleModel>): List<Long>

    @Query("SELECT COUNT(*) FROM jsonFeed")
    fun getCount(): Int

    @Query("SELECT * FROM jsonFeed")
    fun getJsonFeed(): Flowable<List<ArticleModel>>
}