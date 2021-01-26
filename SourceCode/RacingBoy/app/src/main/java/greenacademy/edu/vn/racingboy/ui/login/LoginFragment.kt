package greenacademy.edu.vn.racingboy.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import greenacademy.edu.vn.racingboy.R
import greenacademy.edu.vn.racingboy.ui.home.HomeFragment


class LoginFragment(val activity: Activity) : Fragment() {
    companion object {
        private const val RC_SIGN_IN = 100
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(activity, gso)
        val account = GoogleSignIn.getLastSignedInAccount(activity)
        val btnSignIn = view.findViewById<Button>(R.id.btnSignInGG)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        btnSignIn.setOnClickListener {
            if (account == null) {
                val signInIntent = mGoogleSignInClient.signInIntent
                startActivityForResult(signInIntent, RC_SIGN_IN)
                btnSignIn.text = "Log out"
            }
        }
        btnLogin.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment, HomeFragment())
                commit()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

        }

    }

}
