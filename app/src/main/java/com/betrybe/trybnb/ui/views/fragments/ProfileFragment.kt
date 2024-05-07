package com.betrybe.trybnb.ui.views.fragments
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.api.RetrofitApi
import com.betrybe.trybnb.data.models.LoginRequest
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment() {
    private val authService = RetrofitApi.service

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        val loginInputLayout = rootView.findViewById<TextInputLayout>(R.id.login_input_profile)
        val passwordInputLayout = rootView.findViewById<TextInputLayout>(R.id.password_input_profile)
        val loginButton = rootView.findViewById<Button>(R.id.login_button_profile)
        val loginSuccessTextView = rootView.findViewById<TextView>(R.id.login_success)

        loginButton.setOnClickListener {
            val loginText = loginInputLayout.editText!!.text.toString()
            val passwordText = passwordInputLayout.editText!!.text.toString()

            val isLoginEmpty = loginText.isEmpty()
            loginInputLayout.error = if (isLoginEmpty) getString(R.string.login_required) else null

            val isPasswordEmpty = passwordText.isEmpty()
            passwordInputLayout.error = if (isPasswordEmpty) getString(R.string.password_required) else null

            if (!isLoginEmpty && !isPasswordEmpty) {
                performLogin(loginText, passwordText, loginSuccessTextView)
            }
        }
        return rootView
    }

    private fun performLogin(username: String, password: String, resultTextView: TextView) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                ApiIdlingResource.increment()
                val body = LoginRequest(username, password)
                val response = authService.loginUser(body)
                if (response.isSuccessful && response.body() != null) {
                    withContext(Dispatchers.Main) {
                        resultTextView.setText(R.string.login_success)
                        resultTextView.visibility = View.VISIBLE
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        resultTextView.setText(R.string.login_failed)
                        resultTextView.visibility = View.VISIBLE
                    }
                }
                ApiIdlingResource.decrement()
            } catch (e: Exception) {
                Log.d("LoginError", e.message.toString())
                withContext(Dispatchers.Main) {
                    resultTextView.setText(R.string.login_failed)
                    resultTextView.visibility = View.VISIBLE
                }
                ApiIdlingResource.decrement()
            }
        }
    }
}