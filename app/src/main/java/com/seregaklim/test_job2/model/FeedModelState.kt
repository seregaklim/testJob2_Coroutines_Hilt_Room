package com.seregaklim.model

import javax.inject.Inject

data class FeedModelState(
    val loading: Boolean = false,
    val error: Boolean = false,
    val refreshing: Boolean = false,
)
