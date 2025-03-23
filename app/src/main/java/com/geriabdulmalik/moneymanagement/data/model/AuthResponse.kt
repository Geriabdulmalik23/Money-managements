package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @SerializedName("status")
    val status: Boolean,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: BodyResponse,

    )

data class BodyResponse(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("email")
    val email: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("token")
    val token: String?

)