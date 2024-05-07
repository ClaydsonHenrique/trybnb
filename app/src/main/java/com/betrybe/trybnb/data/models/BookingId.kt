package com.betrybe.trybnb.data.models

data class bookingId(val bookId: Int)
data class bookCheckIn(val checkIn: String, val checkOut: String)
data class bookingGetId(val name:String, val secondName: String,
                        val price: Int,
                        val depositoPrice: Boolean,
                        val dates: bookCheckIn,
                        val adicionais: String, )


