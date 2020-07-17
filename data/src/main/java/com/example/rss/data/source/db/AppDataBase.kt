package com.example.rss.data.source.db

import androidx.room.RoomDatabase

//@Database(entities = [], version = AppDataBase.VERSION)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        const val DB_NAME = "rss.db"
        const val VERSION = 1
    }
}