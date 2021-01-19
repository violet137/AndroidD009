package greenacademy.edu.vn.racingboy.ui.home

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import greenacademy.edu.vn.racingboy.R


class CarBackgroundFragment : Fragment() {
    private var screenWidth = 0
    private var screenHeight = 0
    val spaceVertical = 50

    lateinit var imgFirstCarView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val carScreen = inflater.inflate(R.layout.fragment_car_background, container, false)
        getScreenSize()
        initView(carScreen)
        playCarMoveAnimation()
        return carScreen
    }

    fun getScreenSize(){
        val wm = context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenWidth = size.x
        screenHeight = size.y
    }

    fun initView(carScreen: View) {
        imgFirstCarView = carScreen.findViewById(R.id.img_first_car)
    }

    fun playCarMoveAnimation() {
        val distanceHeightMove = screenHeight/10
        val startBottomPointMove = distanceHeightMove * -1

        imgFirstCarView.let {
//            val location = IntArray(2)
//            it?.getLocationInWindow(location)
            if(it != null) {
                val set = AnimationSet(false)

                val animT = TranslateAnimation(0f, 0f, 0f, (screenHeight.toFloat() * 1.3f)* -1)
                val endOpacity = AlphaAnimation(1f, 0f)
                endOpacity.duration = 6000
                val startOpacity = AlphaAnimation(0f, 1f)
                startOpacity.duration = 5000
                set.addAnimation(animT)
                set.addAnimation(endOpacity)
                set.duration = 5000
                set.startOffset = startBottomPointMove.toLong()
                set.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        it.startAnimation(set)
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })

                it.startAnimation(set)
            }
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
                CarBackgroundFragment().apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
//                    }
                }
    }
}