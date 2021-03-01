package greenacademy.edu.vn.racingboy.ui.buyitem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Item

class BuyItemAdapter(
    val datas: ArrayList<Item>,
    val itemCallback: ((Item) -> Unit)? = null,
    val buyCallback: ((Item) -> Unit)? = null
) : RecyclerView.Adapter<BuyItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.buy_item, parent, false)
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
        holder.itemView.setOnClickListener {
            itemCallback?.invoke(item)
        }
        holder.btnBuy.setOnClickListener {
            buyCallback?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

}


class BuyItemHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image = view.findViewById<CircleImageView>(R.id.imvItem)
    val price = view.findViewById<TextView>(R.id.tvItemPrice)
    val name = view.findViewById<TextView>(R.id.tvItemName)
    val btnBuy = view.findViewById<Button>(R.id.btnBuyItem)
}





