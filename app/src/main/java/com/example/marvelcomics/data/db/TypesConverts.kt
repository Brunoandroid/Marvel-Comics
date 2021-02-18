package com.example.marvelcomics.data.db

import androidx.room.TypeConverter
import com.example.marvelcomics.data.model.Comic
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypesConverts {

    var gson = Gson()

    @TypeConverter
    fun comicToString(comic: Comic): String {
        return gson.toJson(comic)
    }

    @TypeConverter
    fun stringToComic(data: String): Comic {
        val listType = object : TypeToken<Comic>() {}.type
        return gson.fromJson(data, listType)
    }


}