package greenacademy.edu.vn.racingboy.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import greenacademy.edu.vn.racingboy.R

class LoginMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_wellcome, container, false)
        val loginBtn = view.findViewById<Button>(R.id.btnToLogin)

        loginBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.let {
                it.add(R.id.fragment, LoginFragment(activity!!))
                it.addToBackStack("LoginMenuFragment")
                it.commit()
            }
        }
        return view
    }
}