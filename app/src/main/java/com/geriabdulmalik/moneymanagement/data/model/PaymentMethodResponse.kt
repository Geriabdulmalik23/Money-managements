package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class PaymentMethodResponse(

    @SerializedName("id")
    val id : Int?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("icon_url")
    val iconUrl : String?,

    @SerializedName("type")
    val type : String?,

)
