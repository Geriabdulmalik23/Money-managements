package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class CheckPriceResponse(

    @SerializedName("product_id")
    val productId : Int?,

    @SerializedName("product_name")
    val productName : String?,

    @SerializedName("product_price")
    val productPrice : Int?,

    @SerializedName("vat")
    val vat : Int?,

    @SerializedName("discount")
    val discount : Int?,

    @SerializedName("total_vat")
    val totalVat : Int?,

    @SerializedName("total_discount")
    val totalDiscount : Int?,

    @SerializedName("total_price")
    val totalPrice : Int?

)
