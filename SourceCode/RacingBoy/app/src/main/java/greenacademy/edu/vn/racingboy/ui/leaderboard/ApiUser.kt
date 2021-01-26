package greenacademy.edu.vn.racingboy.ui.leaderboard

import greenacademy.edu.vn.racingboy.model.Item
import greenacademy.edu.vn.racingboy.ui.leaderboard.model.LeaderBoardUser
import retrofit2.Call
import retrofit2.http.GET

interface ApiUser {
    @GET("LeaderBoardUser")
    fun listUser(): Call<List<LeaderBoardUser>>
}