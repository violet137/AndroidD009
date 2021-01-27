package greenacademy.edu.vn.racingboy.ui.buycar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import greenacademy.edu.vn.racingboy.R

class BuyCarFragment : Fragment() {

    var BuyCarData = arrayListOf<DataBuyCar>()
    var tvSpeed: TextView? = null
    var tvHandling : TextView? = null
    var tvNameCar : TextView? = null
    var tvAcce : TextView? = null
    var tvMonnetLetBuy : TextView? = null
    var seekbarSpeed : ProgressBar? = null
    var seekbarHandling : ProgressBar? = null
    var seekbarAcce : ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewBuyCarFragment = inflater.inflate(R.layout.fragment_buycar, container, false)
        // -> Star


        val Vpage2 = viewBuyCarFragment.findViewById<ViewPager2>(R.id.V_page2)
        val btnBack = viewBuyCarFragment.findViewById<Button>(R.id.btnBack)
        val btnNext = viewBuyCarFragment.findViewById<Button>(R.id.btnNext)

        tvSpeed = viewBuyCarFragment.findViewById<TextView>(R.id.tvSpeed)
        tvHandling = viewBuyCarFragment.findViewById(R.id.tvHandling)
        tvNameCar = viewBuyCarFragment.findViewById(R.id.tvNameCar)
        tvAcce = viewBuyCarFragment.findViewById(R.id.tvAcce)
        tvMonnetLetBuy = viewBuyCarFragment.findViewById(R.id.tvMonneyCar)
        seekbarSpeed =  viewBuyCarFragment.findViewById(R.id.seekBar)
        seekbarHandling =  viewBuyCarFragment.findViewById(R.id.seekBar2)
        seekbarAcce =  viewBuyCarFragment.findViewById(R.id.seekBar3)
        initDataBuyCar()
        Vpage2.adapter = AdapterViewPageCar(BuyCarData)
        btnBack.setOnClickListener {
            Vpage2.currentItem = Vpage2.currentItem - 1
        }
        btnNext.setOnClickListener {
            Vpage2.currentItem = Vpage2.currentItem + 1
        }
        Vpage2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                loadDataItem(position)
            }
        })

        // -> End
        return viewBuyCarFragment
    }

    fun loadDataItem(position: Int) {
        val itemData = BuyCarData.get(position)
        tvSpeed?.text = "${itemData.speed} Km/h "
        tvHandling?.text = "${itemData.handling.toLong()} G's"
        tvNameCar?.text = "${itemData.nameCar}"
        tvAcce?.text = "${itemData.acceleration} S "
        tvMonnetLetBuy?.text = "${itemData.monneyLetbuyCar} $"
        seekbarSpeed?.progress = itemData.speed?.div(3)!!
        seekbarHandling?.progress = itemData.handling / 20
       // seekbarAcce?.progress = itemData.acceleration /
    }

    fun initDataBuyCar() {
        val Car1 = DataBuyCar(
            R.drawable.car, "Exciter 155", 185, 1285, 3.1, "57000000"
        )
        BuyCarData.add(Car1)
        val Car2 = DataBuyCar(
            R.drawable.bus, "Winner X", 174, 1156, 3.1,"47000000"
        )
        BuyCarData.add(Car2)
    }
}