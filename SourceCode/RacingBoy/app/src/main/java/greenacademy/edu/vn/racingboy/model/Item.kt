package greenacademy.edu.vn.racingboy.model

import com.google.gson.annotations.SerializedName


class Item(
        @SerializedName("image")    val image: String,
        @SerializedName("price") val price: Int,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String
)

