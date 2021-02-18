package com.example.marvelcomics.data.db.cart

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvelcomics.data.db.TypesConverts

@Database(
        entities = [CartComics::class],
        version = 1,
        exportSchema = false
    )

    @TypeConverters(TypesConverts::class)
    abstract class AppDBCart: RoomDatabase() {

        abstract fun getCartDao(): CartDao

    }
