package com.seregaklim.model

import com.seregaklim.data.ResponseX
import javax.inject.Inject

data class FeedModel(
    val responseX: List<ResponseX> = emptyList(),
    val empty: Boolean = false,
)