package greenacademy.edu.vn.racingboy.ui.buyitem

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Item
import greenacademy.edu.vn.racingboy.ui.buyitem.detail.DetailItemDialogFragement
import retrofit2.Call
import retrofit2.Response


class BuyItemFragment() : Fragment() {

    var datas: ArrayList<Item> = arrayListOf()
    var adapter: BuyItemAdapter? = null
    var rvItems: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buy_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvItems = view.findViewById(R.id.recyclerviewBuyItem)
        rvItems?.layoutManager =
            GridLayoutManager(context, 2)
        // goi lấy data từ server
        callItemApi()
    }

    fun callItemApi() {
        ApiClient.getClient.listItems().enqueue(object : retrofit2.Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                response.body()?.let {
                    // chứa data server trả về
                    datas = it as ArrayList<Item>
                    Log.d("testitem", "${datas.size}")
                    adapter = BuyItemAdapter(datas,
                        itemCallback = { data ->
                            // khi user nhấn vào item
                            fragmentManager?.let { it1 ->
                                DetailItemDialogFragement.show(
                                    it1,
                                    data
                                )
                            }
                        }, buyCallback = { data ->
                            // khi user nhấn vào nút buy
                            Toast.makeText(context, "mua vat pham", Toast.LENGTH_LONG).show()
                        })
                    rvItems?.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                // bắt trường hợp lỗi
                Log.d("onFailure", "onFailure")
            }
        })

    }

}