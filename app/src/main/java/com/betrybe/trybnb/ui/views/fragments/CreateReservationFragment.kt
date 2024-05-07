package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class CreateReservationFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_reservation, container, false)

        val firstNameInput = view.findViewById<TextInputLayout>(R.id.first_name_create_reservation)
        val lastNameInput = view.findViewById<TextInputLayout>(R.id.last_name_create_reservation)
        val checkinInput = view.findViewById<TextInputLayout>(R.id.checkin_create_reservation)
        val checkoutInput = view.findViewById<TextInputLayout>(R.id.checkout_create_reservation)
        val additionalNeedsInput = view.findViewById<TextInputLayout>(R.id.additional_needs_create_reservation)
        val totalPriceInput = view.findViewById<TextInputLayout>(R.id.total_price_create_reservation)
        val createButton = view.findViewById<Button>(R.id.create_reservation_button)

        createButton.setOnClickListener {

            if (firstNameInput.editText?.text.isNullOrEmpty()) {
                firstNameInput.error = "O campo Nome é obrigatório"
            } else {
                firstNameInput.error = null
            }
            if (lastNameInput.editText?.text.isNullOrEmpty()) {
                lastNameInput.error = "O campo Sobrenome é obrigatório"
            } else {
                lastNameInput.error = null
            }
            if (checkinInput.editText?.text.isNullOrEmpty()) {
                checkinInput.error = "O campo Checkin é obrigatório"
            } else {
                checkinInput.error = null
            }
            if (checkoutInput.editText?.text.isNullOrEmpty()) {
                checkoutInput.error = "O campo Checkout é obrigatório"
            } else {
                checkoutInput.error = null
            }
            if (additionalNeedsInput.editText?.text.isNullOrEmpty()) {
                additionalNeedsInput.error = "O campo Necessidades Adicionais é obrigatório"
            } else {
                additionalNeedsInput.error = null
            }

            if (totalPriceInput.editText?.text.isNullOrEmpty()) {
                totalPriceInput.error = "O campo Preço Total é obrigatório"
            } else {
                totalPriceInput.error = null
            }

        }

        return view
    }
}