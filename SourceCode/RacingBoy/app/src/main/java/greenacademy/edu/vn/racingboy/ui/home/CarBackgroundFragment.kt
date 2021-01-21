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
    lateinit var imgBackgroundFirstCarView: ImageView
    lateinit var imgSecondCarView: ImageView
    lateinit var imgBackgroundSecondCarView: ImageView
    lateinit var imgThirdCarView: ImageView
    lateinit var imgBackgroundThirdCarView: ImageView

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

    fun getScreenSize() {
        val wm = context!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenWidth = size.x
        screenHeight = size.y
    }

    fun initView(carScreen: View) {
        imgFirstCarView = carScreen.findViewById(R.id.img_first_car)
        imgBackgroundFirstCarView = carScreen.findViewById(R.id.background_first_car)
        imgBackgroundSecondCarView = carScreen.findViewById(R.id.background_second_car)
        imgSecondCarView = carScreen.findViewById(R.id.img_second_car)
        imgBackgroundThirdCarView = carScreen.findViewById(R.id.background_third_car)
        imgThirdCarView = carScreen.findViewById(R.id.img_third_car)
    }

    fun playCarMoveAnimation() {
        val distanceHeightMove = screenHeight / 10
        val startBottomPointMove = distanceHeightMove * -1

//        imgFirstCarView.let {
////            val location = IntArray(2)
////            it?.getLocationInWindow(location)
//            if(it != null) {

        var set = createAnimationSet(startBottomPointMove.toLong())
        set.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                imgFirstCarView.startAnimation(set)
                imgBackgroundFirstCarView.startAnimation(set)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        imgFirstCarView.startAnimation(set)
        imgBackgroundFirstCarView.startAnimation(set)
        imgSecondCarView.startAnimation(set)
        imgBackgroundSecondCarView.startAnimation(set)
        imgThirdCarView.startAnimation(set)
        imgBackgroundThirdCarView.startAnimation(set)


//        val thread = Thread {
//            Thread.sleep(1000)
//
//            var set = createAnimationSet(startBottomPointMove.toLong())
//            set.setAnimationListener(object : Animation.AnimationListener {
//                override fun onAnimationStart(animation: Animation?) {
//
//                }
//
//                override fun onAnimationEnd(animation: Animation?) {
//                    imgSecondCarView.startAnimation(set)
//                    imgBackgroundSecondCarView.startAnimation(set)
//                }
//
//                override fun onAnimationRepeat(animation: Animation?) {
//
//                }
//            })
//
//            imgSecondCarView.startAnimation(set)
//            imgBackgroundSecondCarView.startAnimation(set)
//
//            Thread.sleep(1000)
//
//            var newSet = createAnimationSet(startBottomPointMove.toLong())
//            newSet.setAnimationListener(object : Animation.AnimationListener {
//                override fun onAnimationStart(animation: Animation?) {
//
//                }
//
//                override fun onAnimationEnd(animation: Animation?) {
//                    imgSecondCarView.startAnimation(newSet)
//                    imgBackgroundSecondCarView.startAnimation(newSet)
//                }
//
//                override fun onAnimationRepeat(animation: Animation?) {
//
//                }
//            })
//
//            imgSecondCarView.startAnimation(newSet)
//            imgBackgroundSecondCarView.startAnimation(newSet)
//        }
//
//        thread.start()
//            }
//        }
    }

    fun createAnimationSet(startBottomPointMove: Long): AnimationSet {
        val set = AnimationSet(false)

        val animT = TranslateAnimation(0f, 0f, 0f, (screenHeight.toFloat() * 1.3f) * -1)
        val endOpacity = AlphaAnimation(1f, 0f)
        endOpacity.duration = 3000
        val startOpacity = AlphaAnimation(0f, 1f)
        startOpacity.duration = 2000
        set.addAnimation(animT)
        set.addAnimation(endOpacity)
        set.duration = 4000
        set.startOffset = startBottomPointMove
        return set
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