package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.api.RetrofitApi
import com.betrybe.trybnb.ui.adapters.AdapterRecycleView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class ReservationFragment : Fragment() {
    private val authService = RetrofitApi.service

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_reservation, container, false)
        val recyclerView = viewRoot.findViewById<RecyclerView>(R.id.reservation_recycler_view)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                ApiIdlingResource.increment()

                val authResponse = authService.getbooking()
                if (authResponse.isSuccessful) {
                    val bookingIds = authResponse.body()
                    if (!bookingIds.isNullOrEmpty()) {
                        val bookingIdsLimited = bookingIds.subList(0, 10)

                        val bookingsList = bookingIdsLimited.map { bookingId ->
                            authService.getBookById(bookingId.bookId.toString()).body()
                        }.filterNotNull()

                        withContext(Dispatchers.Main) {
                            val isAdapter = AdapterRecycleView(bookingsList)
                            val context = view?.context
                            recyclerView.layoutManager = LinearLayoutManager(context)
                            recyclerView.adapter = isAdapter
                        }
                    }
                }
                ApiIdlingResource.decrement()
            } catch (e: HttpException) {
                ApiIdlingResource.decrement()
                Log.e("HttpException", e.message(), e)
            } catch (e: IOException) {
                ApiIdlingResource.decrement()
                Log.e("IOException", e.message, e)
            }
        }

        return viewRoot
    }
}