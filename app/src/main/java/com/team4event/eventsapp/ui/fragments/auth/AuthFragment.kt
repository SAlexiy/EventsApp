package com.team4event.eventsapp.ui.fragments.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.Navigator
import com.team4event.eventsapp.AuthActivity
import com.team4event.eventsapp.MainActivity
import com.team4event.eventsapp.R
import com.team4event.eventsapp.consts.SharedPreferenceKeys
import com.team4event.eventsapp.ui.fragments.auth.screens.LoginScreen
import kotlinx.coroutines.launch
import java.util.logging.Logger


class AuthFragment : Fragment() {
    private val logger = Logger.getLogger("AuthFragment")

    companion object {
        fun newInstance() = AuthFragment()
        lateinit var viewModel: AuthViewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = AuthViewModel.getInstance()
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val composeView = view.findViewById<ComposeView>(R.id.auth_compose)
        composeView.setContent {
            Navigator(LoginScreen())
        }




        lifecycleScope.launch {
            viewModel.authState.value.collect{
                logger.info("yes1")

                if (it != null){

                    logger.info("yes2")
                    AuthActivity.settings.edit().putString(SharedPreferenceKeys.AUTH_KEY,it).apply()
                    logger.info("yes3")
                    startActivity(Intent(activity,MainActivity::class.java))
                    logger.info("yes4")

                } else {
                    logger.info("ошибка")
                    Toast.makeText(activity,"ошибка",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}