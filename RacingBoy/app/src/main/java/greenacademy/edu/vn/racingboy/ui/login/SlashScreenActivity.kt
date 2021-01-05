package greenacademy.edu.vn.racingboy.ui.login

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import greenacademy.edu.vn.racingboy.MainActivity
import greenacademy.edu.vn.racingboy.R
import kotlinx.android.synthetic.main.activity_slash_screen.*

class SlashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash_screen)
        // load video
        videoView.setVideoURI(
            Uri.parse("android.resource://"
                + packageName + "/" + R.raw.intro_s))
        videoView.start()
        // bắt sự kiện play xong 1 video
        videoView.setOnCompletionListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}