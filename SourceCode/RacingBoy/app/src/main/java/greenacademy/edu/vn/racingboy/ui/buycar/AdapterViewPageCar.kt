package greenacademy.edu.vn.racingboy.ui.buycar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import greenacademy.edu.vn.racingboy.R

class AdapterViewPageCar(val datas: ArrayList<DataBuyCar>) :
    RecyclerView.Adapter<ViewHolderViewPageCar>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderViewPageCar {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item__car_viewpage, parent, false)
        return ViewHolderViewPageCar(view)
    }

    override fun onBindViewHolder(holder: ViewHolderViewPageCar, position: Int) {
        val item = datas.get(position)
        holder.ImageCar.setImageResource(item.imageCar)
        holder.NameCar.text = item.nameCar
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}

class ViewHolderViewPageCar(val ctView: View) : RecyclerView.ViewHolder(ctView) {
    val ImageCar = ctView.findViewById<ImageView>(R.id.imgCar)
    val NameCar = ctView.findViewById<TextView>(R.id.tvNameCar)
}