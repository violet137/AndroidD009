package greenacademy.edu.vn.racingboy.ui.leaderboard

import android.graphics.Color
import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.api.internal.BackgroundDetector
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.ui.buyitem.ApiClient
import greenacademy.edu.vn.racingboy.ui.leaderboard.model.LeaderBoardUser
import retrofit2.Call
import retrofit2.Response


class LeaderBoardFragment() : Fragment() {
    var datas: ArrayList<LeaderBoardUser> = arrayListOf()
    var adapter: LeaderBoardAdapter? = null
    var rv: RecyclerView? = null

    val btnAll = view?.findViewById<Button>(R.id.btnAll)
    val btnFriend = view?.findViewById<Button>(R.id.btnFriend)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leader_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.rvLeaderBoard)
        callUserApi()

        btnAll?.setOnClickListener {
            btnAll.setBackgroundResource(R.drawable.leaderboard_button_bg)
            btnFriend?.background == null
        }
        btnFriend?.setOnClickListener {
            btnFriend.setBackgroundResource(R.drawable.leaderboard_button_bg)
            btnAll?.background = null
        }

    }


    fun callUserApi() {
        ApiClient.getUsers.listUser().enqueue(object : retrofit2.Callback<List<LeaderBoardUser>> {
            override fun onResponse(
                call: Call<List<LeaderBoardUser>>,
                response: Response<List<LeaderBoardUser>>
            ) {
                response?.body().let {
                    datas = it as ArrayList<LeaderBoardUser>
                    adapter = LeaderBoardAdapter(datas, inviteCallback = {

                    })
                    rv?.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<LeaderBoardUser>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}



