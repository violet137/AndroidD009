package greenacademy.edu.vn.racingboy.ui.buyitem

import android.app.Activity
import android.app.Dialog
import android.app.Service
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.text.Layout
import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.PicassoProvider
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Item
import kotlin.coroutines.coroutineContext
import androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback as PopupCallback1

class BuyItemAdapter(val datas:ArrayList<Item>,val activity: Activity):RecyclerView.Adapter<BuyItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.buy_item,parent,false)
        return BuyItemHolder(view)
    }

    override fun onBindViewHolder(holder: BuyItemHolder, position: Int) {
       val item = datas[position]
        Picasso
            .get()
            .load(item.image)
            .into(holder.image)
        holder.price.text = item.price.toString()
        holder.name.text = item.name
        holder.image.setOnClickListener {


    }}
    override fun getItemCount(): Int {
       return datas.size
    }

}



class BuyItemHolder(view:View):RecyclerView.ViewHolder(view){
    val image = view.findViewById<ImageView>(R.id.imvItem)
    val price = view.findViewById<TextView>(R.id.tvItemPrice)
    val name = view.findViewById<TextView>(R.id.tvItemName)
    val btnBuy = view.findViewById<Button>(R.id.btnBuyItem)
}





