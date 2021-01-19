package greenacademy.edu.vn.racingboy.ui.buyitem

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Item
import greenacademy.edu.vn.racingboy.ui.login.MainActivity


class BuyItemFragment (val datas :ArrayList<Item>,val activity: Activity): Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_buy_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       view.findViewById<RecyclerView>(R.id.recyclerviewBuyItem).layoutManager = GridLayoutManager(context,2)
        val adapter = BuyItemAdapter(datas,activity)
        view.findViewById<RecyclerView>(R.id.recyclerviewBuyItem).adapter=adapter
    }
}