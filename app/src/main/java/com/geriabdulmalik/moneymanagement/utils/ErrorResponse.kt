package com.geriabdulmalik.moneymanagement.utils

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody

data class ErrorResponse(

    @SerializedName("status")
    val status: Boolean? = false,

    @SerializedName("message")
    val message: String? = "Unknown error"

)

fun ResponseBody.parseError(): ErrorResponse {
    val gson = Gson()
    return gson.fromJson(charStream(), ErrorResponse::class.java)
}