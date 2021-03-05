package com.example.marvelcomics.domain.model

import com.example.marvelcomics.data.model.Comic
import java.io.Serializable

data class DataModel(
    val count: Int,
    val comics: List<Comic>
): Serializable
