package greenacademy.edu.vn.racingboy.ui.home

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.ui.buyitem.BuyItemFragment
import greenacademy.edu.vn.racingboy.ui.game.GameFragment
import greenacademy.edu.vn.racingboy.ui.leaderboard.LeaderBoardFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        fragmentManager?.beginTransaction()?.replace(R.id.mainframe, CarBackgroundFragment())?.commit()
        mediaPlayer = MediaPlayer.create(context, R.raw.background_music)

        mediaPlayer?.start()
        val btnPlay = view.findViewById<Button>(R.id.btnPlay)
        btnPlay.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment, GameFragment())
                addToBackStack("")
                commit()
            }
        }

        val leaderBoardButton = view.findViewById<ImageView>(R.id.imgHomeLeaderboard)
        leaderBoardButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.let {
                it.add(R.id.fragment, LeaderBoardFragment())
                it.addToBackStack("LeaderBoardFragment")
                it.commit()
            }
        }

        val shop = view.findViewById<ImageView>(R.id.imgHomeShop)
        shop.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                add(R.id.fragment, BuyItemFragment())
                addToBackStack("BuyItemFragment")
                commit()
            }
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}