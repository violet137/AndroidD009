package greenacademy.edu.vn.racingboy.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.ui.buycar.BuyCarFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,BuyCarFragment())
            commit()
        }
    }
}