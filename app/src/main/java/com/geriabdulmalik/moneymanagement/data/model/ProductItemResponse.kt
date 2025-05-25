package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class ProductItemResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("product_id")
    val productId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("base_price")
    val basePrice: Int,


    )
