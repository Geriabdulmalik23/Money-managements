package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @SerializedName("user")
    val user: UserResponse?,

    @SerializedName("token")
    val token: String?

)
