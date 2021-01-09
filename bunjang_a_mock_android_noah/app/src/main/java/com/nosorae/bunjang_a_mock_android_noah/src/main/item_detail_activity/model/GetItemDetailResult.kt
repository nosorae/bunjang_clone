package com.nosorae.bunjang_a_mock_android_noah.src.main.item_detail_activity.model

data class GetItemDetailResult(
    val info: Info,
    val productImg: List<ProductImg>,
    val productTag: List<ProductTag>,
    val reviewList: List<Review>,
    val saleList: List<Sale>
)