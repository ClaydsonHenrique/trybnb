package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class ProfileFragment : Fragment() {

    private lateinit var loginInputLayout: TextInputLayout
    private lateinit var passwordInputLayout: TextInputLayout
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_profile, container, false)

        loginInputLayout = viewRoot.findViewById(R.id.login_input_profile)
        passwordInputLayout = viewRoot.findViewById(R.id.password_input_profile)
        loginButton = viewRoot.findViewById(R.id.login_button_profile)

        loginButton.setOnClickListener {
            validateLoginAndPassword()
        }

        return viewRoot
    }

    private fun validateLoginAndPassword() {
        val loginText = loginInputLayout.editText?.text.toString().trim()
        val passwordText = passwordInputLayout.editText?.text.toString().trim()

        if (loginText.isEmpty()) {
            loginInputLayout.error = "O campo Login é obrigatório"
        } else {
            loginInputLayout.error = null
        }

        if (passwordText.isEmpty()) {
            passwordInputLayout.error = "O campo Password é obrigatório"
        } else {
            passwordInputLayout.error = null
        }
    }
}
