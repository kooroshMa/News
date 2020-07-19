package com.example.rss.di.module

import android.content.Context
import androidx.room.Room
import com.example.rss.data.source.db.AppDataBase
import com.example.rss.data.source.db.dao.JsonFeedDao
import com.example.rss.data.source.db.dao.XmlFeedDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): AppDataBase {
        return Room
            .databaseBuilder(context, AppDataBase::class.java, AppDataBase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideXmlFeedDao(appDataBase: AppDataBase): XmlFeedDao {
        return appDataBase.xmlFeedDao()
    }

    @Provides
    fun provideJsonFeedDao(appDataBase: AppDataBase): JsonFeedDao {
        return appDataBase.jsonFeedDao()
    }
}