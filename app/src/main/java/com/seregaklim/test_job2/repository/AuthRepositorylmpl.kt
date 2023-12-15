package com.seregaklim.test_job2.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.seregaklim.api.ApiService
import com.seregaklim.dao.ResponsePDao
import com.seregaklim.data.AuthRequest
import com.seregaklim.data.ErrorUserToken
import com.seregaklim.data.UserToken
import com.seregaklim.entity.ResponsePEntity
import com.seregaklim.entity.toDto
import com.seregaklim.error.ApiError
import com.seregaklim.error.NetworkError
import com.seregaklim.repository.ResponsePRepository
import java.io.IOException
import javax.inject.Inject

class AuthRepositorylmpl @Inject constructor (

    val apiService: ApiService,
) : AuthRepository {

  override val erorAuth= MutableLiveData<ErrorUserToken>()
    override val tokenData= MutableLiveData<String>()

    override suspend fun auth(authRequest: AuthRequest) {
        try {
            val response = apiService.auth(authRequest)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiError(response.code(), response.message())
            erorAuth.value = body.error
           Log.d("MyLog", "  erorAuth.value ${erorAuth.value}")
            tokenData.value = body.response.token
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {

        }
    }

}