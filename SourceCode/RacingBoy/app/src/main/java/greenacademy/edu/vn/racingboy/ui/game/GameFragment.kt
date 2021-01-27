package greenacademy.edu.vn.racingboy.ui.game

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Position
import greenacademy.edu.vn.racingboy.ui.home.CarBackgroundFragment

class GameFragment : Fragment() {

    companion object {
        private const val WidthSize = 8
        private const val HeightSize = 16
    }

    val positionA = Position(4, 0)
    val positionB = Position(5, 0)
    var imvA: ImageView? = null
    var imvB: ImageView? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        imvA = view.findViewById(R.id.imvA)
        imvB = view.findViewById(R.id.imvB)
        renderCar()
        val btnLeft = view.findViewById<Button>(R.id.btnLeft)
        val btnRight = view.findViewById<Button>(R.id.btnRight)
        btnLeft.setOnClickListener {
            positionA.x = positionA.x - 1
            renderCar()
        }
        btnRight.setOnClickListener {
            positionA.x = positionA.x + 1
            renderCar()
        }
        return view
    }

    fun renderCar() {
        val widthScreen = resources.displayMetrics.widthPixels
        val heightScreen = resources.displayMetrics.heightPixels
        val widthCell = widthScreen / WidthSize
        val heightCell = heightScreen / HeightSize
        val marginBottom = 300
        val marginLeft = 50
        imvA?.let {
            it.x = positionA.x * widthCell.toFloat() + marginLeft
            it.y = heightScreen - (positionA.y * heightCell.toFloat()) - marginBottom
        }
        imvB?.let {
            it.x = positionB.x * widthCell.toFloat() + marginLeft
            it.y = heightScreen - (positionB.y * heightCell.toFloat()) - marginBottom
        }
    }

}