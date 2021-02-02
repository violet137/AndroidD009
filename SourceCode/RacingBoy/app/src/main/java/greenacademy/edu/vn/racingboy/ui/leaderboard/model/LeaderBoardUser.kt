package greenacademy.edu.vn.racingboy.ui.leaderboard.model

import com.google.gson.annotations.SerializedName

class LeaderBoardUser(
    @SerializedName("hinh") val hinh: String,
    @SerializedName("ten") val ten: String,
    @SerializedName("xp") val xp: Int,
    @SerializedName("hinhtop") val hinhTop: String,
    @SerializedName("huyhieu") val huyHieu: String
)