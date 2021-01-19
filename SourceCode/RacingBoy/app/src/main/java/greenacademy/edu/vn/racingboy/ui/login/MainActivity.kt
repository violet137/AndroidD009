package greenacademy.edu.vn.racingboy.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.squareup.picasso.Callback
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Item
import greenacademy.edu.vn.racingboy.ui.buyitem.ApiClient
import greenacademy.edu.vn.racingboy.ui.buyitem.BuyItemFragment
import retrofit2.Call
import retrofit2.Response
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    var itemData = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread{
            callItemApi()
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, BuyItemFragment(itemData,this@MainActivity))
            commit()
        }
    }


    fun callItemApi() {
        ApiClient.getClient.listItems().enqueue(object : retrofit2.Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                response.body()?.let {
                    // chứa data server trả về
                    itemData = it as ArrayList<Item>
                    Log.d("testitem",itemData.toString())
                }
            }
            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                // bắt trường hợp lỗi
            }
        })

    }
}


