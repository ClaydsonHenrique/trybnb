package com.betrybe.trybnb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.bookingGetId

class AdapterRecycleView(private val bookingList: List<bookingGetId>) : RecyclerView.Adapter<AdapterRecycleView.BookingViewHolder>() {

    class BookingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name_item_reservation)
        val checkIn: TextView = view.findViewById(R.id.checkin_item_reservation)
        val checkOut: TextView = view.findViewById(R.id.checkout_item_reservation)
        val additionalNeeds: TextView = view.findViewById(R.id.additional_needs_item_reservation)
        val price: TextView = view.findViewById(R.id.total_price_item_reservation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_reservation, parent, false)
        return BookingViewHolder(itemView)
    }

    override fun getItemCount(): Int = bookingList.size

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
            val booking = bookingList[position]
            holder.name.text = "${booking.name} ${booking.secondName}"
            holder.checkIn.text = booking.dates.checkIn
            holder.checkOut.text = booking.dates.checkOut
            holder.additionalNeeds.text = booking.adicionais
            holder.price.text = booking.price.toString()
    }
}
