package greenacademy.edu.vn.racingboy.ui.game

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Position

enum class Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN
}

class GameFragment : Fragment() {

    companion object {
        private const val WidthSize = 8
        private const val HeightSize = 16
    }

    val positionA = Position(4, 0)
    val positionB = Position(5, 0)
    var imvA: ImageView? = null
    var imvB: ImageView? = null
    var roomId: Long = 2
    var userType: Int = 0

    // firebass realtime
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // khởi tạo kết nối với firebase
        database = Firebase.database.reference
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        imvA = view.findViewById(R.id.imvA)
        imvB = view.findViewById(R.id.imvB)
        renderCar()
        val btnLeft = view.findViewById<Button>(R.id.btnLeft)
        val btnRight = view.findViewById<Button>(R.id.btnRight)
        val imvBg = view.findViewById<ImageView>(R.id.imvBg)
        btnLeft.setOnClickListener {
            handleLocationCar(Direction.LEFT)
        }
        btnRight.setOnClickListener {
            handleLocationCar(Direction.RIGHT)
        }
        onListenerDatabase()
        // loop background

        ObjectAnimator.ofFloat(imvBg, "translationY", 1920F).apply {
            duration = 10000
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE
            start()
        }
        return view
    }

    fun handleLocationCar(direction: Direction) {
        var step = 0
        when (direction) {
            Direction.LEFT -> step--
            Direction.RIGHT -> step++
        }
        if (userType == 0) {
            positionA.x = positionA.x + step
        } else if (userType == 1) {
            positionB.x = positionB.x + step
        }
        renderCar()
        updateLocationCar()
    }

    // lang data tu server tra ve
    fun onListenerDatabase() {
        val rooms = database.child("rooms")
        rooms.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    Log.d(
                        "danh sach phong",
                        "danh sach phopng:${ds.child("ten").value}"
                    )
                }
                // demo lấy room đầu tiên
                val room1 = snapshot.children.firstOrNull()
                room1?.let {
                    val posA = room1.child("position_a")
                    positionA.x = posA.child("x").value as Long
                    positionA.y = posA.child("y").value as Long
                    val posB = room1.child("position_b")
                    positionB.x = posB.child("x").value as Long
                    positionB.y = posB.child("y").value as Long
                    renderCar()
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun updateLocationCar() {
        val queryRef: Query = database.child("rooms")
        queryRef.orderByChild("id").equalTo(roomId.toDouble())
            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    val data = snapshot.children.first()
                    when (userType) {
                        0 -> {
                            val posA = data.child("position_a")
                            posA.child("x").ref.setValue(positionA.x)
                            posA.child("y").ref.setValue(positionA.y)
                        }
                        1 -> {
                            val posB = data.child("position_b")
                            posB.child("x").ref.setValue(positionB.x)
                            posB.child("y").ref.setValue(positionB.y)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }
            })
    }

    fun renderCar() {
        val widthScreen = resources.displayMetrics.widthPixels
        val heightScreen = resources.displayMetrics.heightPixels
        val widthCell = widthScreen / WidthSize
        val heightCell = heightScreen / HeightSize
        val marginBottom = 300
        val marginLeft = 50
        imvA?.let {
            translationX(it, positionA.x * widthCell.toFloat() + marginLeft)
            translationY(it, heightScreen - (positionA.y * heightCell.toFloat()) - marginBottom)
        }
        imvB?.let {
            translationX(it, positionB.x * widthCell.toFloat() + marginLeft)
            translationY(it, heightScreen - (positionB.y * heightCell.toFloat()) - marginBottom)
        }
    }

    fun translationX(view: View, position: Float) {
        ObjectAnimator.ofFloat(view, "translationX", position).apply {
            duration = 1000
            start()
        }
    }

    fun translationY(view: View, position: Float) {
        ObjectAnimator.ofFloat(view, "translationY", position).apply {
            duration = 1000
            start()
        }
    }
}