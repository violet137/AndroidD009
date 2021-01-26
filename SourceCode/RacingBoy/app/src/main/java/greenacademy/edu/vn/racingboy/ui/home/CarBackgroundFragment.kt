package greenacademy.edu.vn.racingboy.ui.home

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import greenacademy.edu.vn.racingboy.R
import java.time.Duration
import kotlin.random.Random


class CarBackgroundFragment : Fragment() {
    private var screenWidth = 0
    private var screenHeight = 0
    val spaceVertical = 50

    lateinit var imgFirstCarView: ImageView
    lateinit var imgSmoke1FirstCar: ImageView
    lateinit var imgSmoke2FirstCar: ImageView

    lateinit var imgSecondCarView: ImageView
    lateinit var imgSmoke1SecondCar: ImageView
    lateinit var imgSmoke2SecondCar: ImageView

    lateinit var imgThirdCarView: ImageView
    lateinit var imgSmoke1ThirdCar: ImageView
    lateinit var imgSmoke2ThirdCar: ImageView

    var listDuration = mutableListOf<Long>()

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
        imgSmoke1FirstCar = carScreen.findViewById(R.id.smoke_car_1_first_car)
        imgSmoke2FirstCar = carScreen.findViewById(R.id.smoke_car_2_first_car)

        imgSecondCarView = carScreen.findViewById(R.id.img_second_car)
        imgSmoke1SecondCar = carScreen.findViewById(R.id.smoke_car_1_second_car)
        imgSmoke2SecondCar = carScreen.findViewById(R.id.smoke_car_2_second_car)

        imgThirdCarView = carScreen.findViewById(R.id.img_third_car)
        imgSmoke1ThirdCar = carScreen.findViewById(R.id.smoke_car_third_car)
        imgSmoke2ThirdCar = carScreen.findViewById(R.id.smoke_car_2_third_car)

        for (i in 1 until 5){
            listDuration.add((i*1000).toLong())
        }
    }

    fun playCarMoveAnimation() {
        val distanceHeightMove = screenHeight / 10
        val startBottomPointMove = distanceHeightMove * -1
        val random = Random

        var set = createAnimationSet(startBottomPointMove.toLong(), listDuration[random.nextInt(listDuration.size)])
        set.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                set.duration = listDuration[random.nextInt(listDuration.size)]
                imgFirstCarView.startAnimation(set)
                imgSmoke1FirstCar.startAnimation(set)
                imgSmoke2FirstCar.startAnimation(set)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        imgFirstCarView.startAnimation(set)
        imgSmoke1FirstCar.startAnimation(set)
        imgSmoke2FirstCar.startAnimation(set)

        val thread = Thread {
            Thread.sleep(3000)

            val handler = Handler(Looper.getMainLooper())
            handler.post {
                var set = createAnimationSet(startBottomPointMove.toLong(), listDuration[random.nextInt(listDuration.size)])
                set.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        set.duration = listDuration[random.nextInt(listDuration.size)]
                        imgSecondCarView.startAnimation(set)
                        imgSmoke1SecondCar.startAnimation(set)
                        imgSmoke2SecondCar.startAnimation(set)
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })

                imgSecondCarView.startAnimation(set)
                imgSmoke1SecondCar.startAnimation(set)
                imgSmoke2SecondCar.startAnimation(set)
            }

            Thread.sleep(2000)

            handler.post {
                var newSet = createAnimationSet(startBottomPointMove.toLong(), listDuration[random.nextInt(listDuration.size)])
                newSet.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        newSet.duration = listDuration[random.nextInt(listDuration.size)]
                        imgThirdCarView.startAnimation(newSet)
                        imgSmoke1ThirdCar.startAnimation(newSet)
                        imgSmoke2ThirdCar.startAnimation(newSet)
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }
                })

                imgThirdCarView.startAnimation(newSet)
                imgSmoke1ThirdCar.startAnimation(newSet)
                imgSmoke2ThirdCar.startAnimation(newSet)
            }
        }

        thread.start()
    }

    fun createAnimationSet(startBottomPointMove: Long, duration: Long): AnimationSet {
        val set = AnimationSet(false)

        val animT = TranslateAnimation(0f, 0f, 0f, (screenHeight.toFloat() * 1.3f) * -1)
        val endOpacity = AlphaAnimation(1f, 0f)
        endOpacity.duration = duration
        val startOpacity = AlphaAnimation(0f, 1f)
        startOpacity.duration = duration
        set.addAnimation(animT)
        set.addAnimation(endOpacity)
        set.duration = duration
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