package com.example.marvelcomics.data.db.cart

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvelcomics.data.model.Comic
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "cart_comics")
@Parcelize
data class CartComics(
    var comic: Comic,
    var price: String,
    var plots: String,
    var amount: Int
) : Serializable, Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}