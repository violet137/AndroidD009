package greenacademy.edu.vn.racingboy.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import greenacademy.edu.vn.racingboy.R
<<<<<<< HEAD
import greenacademy.edu.vn.racingboy.ui.buycar.BuyCarFragment
=======
import greenacademy.edu.vn.racingboy.ui.buyitem.BuyItemFragment
import greenacademy.edu.vn.racingboy.ui.leaderboard.LeaderBoardFragment
import greenacademy.edu.vn.racingboy.ui.leaderboard.model.LeaderBoardUser

class MainActivity() : AppCompatActivity() {
>>>>>>> qy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
<<<<<<< HEAD
            replace(R.id.fragment,BuyCarFragment())
=======
            replace(R.id.fragment, LeaderBoardFragment())
//            replace(R.id.fragment, BuyItemFragment())
>>>>>>> qy
            commit()
        }
    }


}


