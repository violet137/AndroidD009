package greenacademy.edu.vn.racingboy.ui.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.ui.leaderboard.model.LeaderBoardUser

class LeaderBoardAdapter(val datas : ArrayList<LeaderBoardUser>
, val inviteCallback: ((LeaderBoardUser) -> Unit)? = null
):RecyclerView.Adapter<LeaderBoardHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderBoardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.leaderboard_item,parent,false)
        return LeaderBoardHolder(view)
    }

    override fun onBindViewHolder(holder: LeaderBoardHolder, position: Int) {
        val item = datas.get(position)
        Picasso.get().load(item.hinh).into(holder.avatar)
        Picasso.get().load(item.hinhTop).into(holder.iconTop)
        holder.ten.text = item.ten
        holder.xp.text = item.xp.toString()
        holder.huyHieu.text = item.huyHieu
        holder.btnInvite.setOnClickListener {
            inviteCallback?.invoke(item)
        }

    }

    override fun getItemCount(): Int {
       return datas.size
    }

}

class  LeaderBoardHolder(view:View):RecyclerView.ViewHolder(view){
    val avatar = view.findViewById<CircleImageView>(R.id.imvAvatar)
    val ten = view.findViewById<TextView>(R.id.tvUserName)
    val xp = view.findViewById<TextView>(R.id.tvUserXP)
    val iconTop = view.findViewById<ImageView>(R.id.imvTop)
    val huyHieu = view.findViewById<TextView>(R.id.tvHuyHieu)
    val btnInvite = view.findViewById<Button>(R.id.btnInviteToPlay)
}