package com.example.rss.di.module

import android.content.Context
import androidx.room.Room
import com.example.rss.data.source.db.AppDataBase
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
}