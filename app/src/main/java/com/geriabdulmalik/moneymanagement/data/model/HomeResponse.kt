package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(

    @SerializedName("balance")
    val balance: BalanceResponse?,

    @SerializedName("banner")
    val banner: String?,

    @SerializedName("game")
    val game: List<ProductResponse>,

    @SerializedName("e_wallet")
    val eWallet: List<ProductResponse>,

    @SerializedName("mobile_credit")
    val mobileCredit: List<ProductResponse>

)
