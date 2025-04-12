package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("createdAt")
    val createdAt: String

)
