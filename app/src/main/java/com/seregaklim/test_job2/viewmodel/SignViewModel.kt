package com.seregaklim.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.seregaklim.api.ApiService
import com.seregaklim.data.AuthRequest
import com.seregaklim.data.ErrorUserToken
import com.seregaklim.data.UserToken
import com.seregaklim.repository.ResponsePRepository
import com.seregaklim.repository.ResponsePRepositorylmpl
import com.seregaklim.test_job2.repository.AuthRepository
import com.seregaklim.test_job2.repository.AuthRepositorylmpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignViewModel @Inject constructor (
    private val apiService: ApiService) :ViewModel() {

    private val repositoryAuth: AuthRepository = AuthRepositorylmpl(apiService)
    val tokenData: LiveData<String> =repositoryAuth.tokenData.map { token: String -> String.toString() }

    fun sigAuth(authRequest: AuthRequest) = viewModelScope.launch {
        try {
            repositoryAuth.auth(authRequest)
        } catch (e: Exception) {

        }
    }
}

