package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class BalanceResponse(

    @SerializedName("clover")
    val clover: Int,

    @SerializedName("energy")
    val energy: Int

)
