package com.geriabdulmalik.moneymanagement.utils

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(

    @SerializedName("success")
    val success: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: T

)