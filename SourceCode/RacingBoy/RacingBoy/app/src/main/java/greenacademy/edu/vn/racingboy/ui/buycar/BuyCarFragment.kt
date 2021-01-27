package greenacademy.edu.vn.racingboy.ui.buycar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import greenacademy.edu.vn.racingboy.R

class BuyCarFragment : Fragment() {

    var BuyCarData = arrayListOf<DataBuyCar>()
    var tvSpeed: TextView? = null

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
        //val item1 = DataBuyCar (R.drawable.car)
        //val item2 = DataBuyCar (R.drawable.bus)

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
        tvSpeed?.text = "${itemData.speed} km/h"
    }

    fun initDataBuyCar() {
        val Car1 = DataBuyCar(
            R.drawable.car, "Exciter", "180", "1.280", "3.1", "57000000"
        )
        BuyCarData.add(Car1)
        val Car2 = DataBuyCar(
            R.drawable.bus, "Winner X", "174", "1.280", "3,5s", "45000000"
        )
        BuyCarData.add(Car2)
    }
}