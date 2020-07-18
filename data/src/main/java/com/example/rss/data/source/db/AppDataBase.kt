package com.example.rss.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rss.data.source.db.dao.XmlFeedDao
import com.example.rss.domain.model.xmlFeed.DetailModel

@Database(entities = [DetailModel::class], version = AppDataBase.VERSION)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DB_NAME = "rss.db"
        const val VERSION = 1
    }
    
    abstract fun xmlFeedDao(): XmlFeedDao
}