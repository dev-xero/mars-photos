package dev.xero.marsphotos.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.xero.marsphotos.MarsPhotosApplication
import dev.xero.marsphotos.api.MarsPhoto
import dev.xero.marsphotos.data.MarsPhotoRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MarsUiState {
	object Loading : MarsUiState
	object Error : MarsUiState

	data class Success(val photos: MarsPhoto) : MarsUiState
}

class MarsViewModel(
	private val marsPhotoRepository: MarsPhotoRepository
) : ViewModel() {
	companion object {
		val Factory: ViewModelProvider.Factory = viewModelFactory {
			initializer {
				val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
				val marsPhotosRepository = application.container.marsPhotoRepository
				MarsViewModel(marsPhotoRepository = marsPhotosRepository)
			}
		}
	}

	var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
		private set

	init {
		getMarsPhotos()
	}

	private fun getMarsPhotos() {
		viewModelScope.launch {
			marsUiState = try {
				val result = marsPhotoRepository.getPhotos()[0]
				Log.d("APP", result.toString())
				MarsUiState.Success(result)
			} catch (e: IOException) {
				MarsUiState.Error
			}
		}
	}
}