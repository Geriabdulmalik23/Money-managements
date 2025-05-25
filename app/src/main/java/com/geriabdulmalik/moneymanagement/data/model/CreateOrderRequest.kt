package com.geriabdulmalik.moneymanagement.data.model

data class CreateOrderRequest(

    val productId: String,

    val optionId: String,

    val methodId: String,

    val gameId: String,

    val server: String

)
