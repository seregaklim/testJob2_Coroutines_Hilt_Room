package com.seregaklim.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.seregaklim.api.ApiService
import com.seregaklim.db.MainDb
import com.seregaklim.model.FeedModel
import com.seregaklim.model.FeedModelState
import com.seregaklim.repository.ResponsePRepository
import com.seregaklim.repository.ResponsePRepositorylmpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ResponsePViewModel @Inject constructor(
    application: Application,
   apiService: ApiService,
  mainDb:MainDb
    ) : AndroidViewModel(application ){

    private val repository: ResponsePRepository= ResponsePRepositorylmpl(
        mainDb.getInstance(context = application).postResponsePDao(),
        apiService)


    val data: LiveData<FeedModel> = repository.data.map(::FeedModel)
    private val _dataState = MutableLiveData<FeedModelState>()
    val dataState: LiveData<FeedModelState>
        get() = _dataState

    fun loadPayments(token: String) = viewModelScope.launch {
        try {
            Log.d("MyLog", " token ${token}")
            _dataState.value = FeedModelState(loading = true)
          repository.getpaymentsAuth(token)
            _dataState.value = FeedModelState()
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }
}






















