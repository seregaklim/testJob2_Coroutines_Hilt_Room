package com.seregaklim.data

import androidx.lifecycle.Observer

data class UserToken (
    val succes:Boolean,
    val error: ErrorUserToken,
    val response:Token
)

data class ErrorUserToken(
    val error_code :String,
    val error_msg :String)

data class Token(
    val token: String
)