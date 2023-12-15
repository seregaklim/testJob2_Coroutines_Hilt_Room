package com.seregaklim.test_job2.repository

import androidx.lifecycle.MutableLiveData
import com.seregaklim.data.AuthRequest
import com.seregaklim.data.ErrorUserToken

interface AuthRepository {
   val erorAuth: MutableLiveData<ErrorUserToken>
    val tokenData: MutableLiveData<String>
    suspend fun auth(authRequest: AuthRequest)
}

