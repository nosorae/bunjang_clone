package com.nosorae.bunjang_a_mock_android_noah.src.main.add_item.add_item_activity.model

import com.google.gson.annotations.SerializedName

data class AddItemRequest(
    @SerializedName("productName") val productName: String,
    @SerializedName("category") val category: Int,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("price") val price: Int,
    @SerializedName("includeDeliveryCharge") val includeDeliveryCharge: Char,
    @SerializedName("isNegotiable") val isNegotiable: Char,
    @SerializedName("area") val area: String,
    @SerializedName("amount") val amount: Int,
    @SerializedName("productState") val productState: Char,
    @SerializedName("isExchangeable") val isExchangeable: Char,
    @SerializedName("productImgUrl") val productImgUrl: Array<String>,
    @SerializedName("productTag") val productTag: Array<String>
)