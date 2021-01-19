package greenacademy.edu.vn.racingboy.ui.buyitem.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.model.Item

class DetailItemDialogFragement : DialogFragment() {

    companion object {

        const val ITEM_DATA = "ITEM_DATA"

        fun show(fm: FragmentManager, item: Item) {
            val detail = DetailItemDialogFragement().apply {
                arguments = Bundle().apply {
                    putSerializable(ITEM_DATA, item)
                }
            }
            detail.show(fm, "DetailItemDialogFragement")
        }
    }

    var data: Item? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_fragment_item_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = arguments?.getSerializable(ITEM_DATA) as Item?
        val imageView = view.findViewById<ImageView>(R.id.imvItem)
        val name = view.findViewById<TextView>(R.id.tvName)
        val price = view.findViewById<TextView>(R.id.tvPrice)
        val description = view.findViewById<TextView>(R.id.tvDescription)
        val ivClose = view.findViewById<ImageView>(R.id.imvClose)
        Picasso
            .get()
            .load(data?.image.orEmpty())
            .into(imageView)
        name.text = data?.name.orEmpty()
        price.text = data?.price.toString()
        description.text = data?.description.orEmpty()
        ivClose.setOnClickListener {
            dismiss()
        }
    }
}