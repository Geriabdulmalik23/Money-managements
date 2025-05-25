package com.geriabdulmalik.moneymanagement.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("image_url")
    val imageUrl: String?,

    @SerializedName("discount")
    val discount: Int?,

    @SerializedName("is_active")
    val isActive: Int?,

    @SerializedName("is_maintenance")
    val isMaintenance: Int?

)
