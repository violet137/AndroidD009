package greenacademy.edu.vn.racingboy.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.ui.buycar.BuyCarFragment
import greenacademy.edu.vn.racingboy.ui.buyitem.BuyItemFragment
import greenacademy.edu.vn.racingboy.ui.leaderboard.LeaderBoardFragment
import greenacademy.edu.vn.racingboy.ui.leaderboard.model.LeaderBoardUser

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, LoginFragment(this@MainActivity))
            commit()
        }
    }


}


