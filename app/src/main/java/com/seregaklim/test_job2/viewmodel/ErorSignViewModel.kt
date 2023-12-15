package com.seregaklim.test_job2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.seregaklim.api.ApiService
import com.seregaklim.data.AuthRequest
import com.seregaklim.data.ErrorUserToken
import com.seregaklim.data.Token
import com.seregaklim.data.UserToken
import com.seregaklim.test_job2.repository.AuthRepository
import com.seregaklim.test_job2.repository.AuthRepositorylmpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ErorSignViewModel @Inject constructor(
    apiService: ApiService,
) : ViewModel() {
    private val repositoryAuth: AuthRepository = AuthRepositorylmpl(apiService)

    var dataErorAuth: MutableLiveData<ErrorUserToken> = repositoryAuth.erorAuth

    fun sigAuthEror(authRequest: AuthRequest) = viewModelScope.launch {
        try {
            repositoryAuth.auth(authRequest)
        } catch (e: Exception) {

        }
    }
}
