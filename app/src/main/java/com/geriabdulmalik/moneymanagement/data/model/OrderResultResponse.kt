package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class OrderResultResponse(

    @SerializedName("user_id")
    val userId: Int,

    @SerializedName("product_id")
    val productId: Int,

    @SerializedName("topup_option_id")
    val optionId: Int,

    @SerializedName("payment_method_id")
    val topupId: Int,

    @SerializedName("user_game_id")
    val gameId: String,

    @SerializedName("server")
    val server: String,

    @SerializedName("qr_code_url")
    val qrCode: String

)
