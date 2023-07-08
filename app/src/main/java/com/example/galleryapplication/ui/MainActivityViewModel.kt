package com.example.galleryapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapplication.data.Repository
import com.example.galleryapplication.data.model.Image
import com.example.galleryapplication.data.network.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState() {
    class Loading() : UiState()
    class Success(val imageList: List<Image>) : UiState()
    class Error(val message: String) : UiState()
}

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _uiState: MutableLiveData<UiState?> by lazy {
        MutableLiveData()
    }
    val uiState: LiveData<UiState?> get() = _uiState

    fun getWeatherUpdates() {
        viewModelScope.launch {
            repository.getImagesFromAssets().collect { it ->
                when (it) {
                    is NetworkResult.Error -> {
                        _uiState.value = UiState.Error(it.message!!)
                    }

                    is NetworkResult.Loading -> {
                        _uiState.value = UiState.Loading()
                    }

                    is NetworkResult.Success -> {
                        it.data?.let { res ->
                            res.let {
                                repository.saveImages(it)
                                _uiState.value = UiState.Success(repository.getImagesFromDb())
                            }
                        }
                    }
                }
            }
        }
    }

    fun setUiState(uiState: UiState) {
        _uiState.value = uiState
    }
}
