package greenacademy.edu.vn.racingboy.ui.buyitem

import greenacademy.edu.vn.racingboy.model.Item
import greenacademy.edu.vn.racingboy.ui.leaderboard.model.LeaderBoardUser
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("item")
    fun listItems(): Call<List<Item>>
}

