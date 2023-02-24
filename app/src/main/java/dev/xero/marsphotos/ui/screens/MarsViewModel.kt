package dev.xero.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.xero.marsphotos.network.MarsApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MarsUiState {
	object Loading : MarsUiState
	object Error : MarsUiState

	data class Success(val photos: String) : MarsUiState
}

class MarsViewModel: ViewModel() {
	var marsUiState: String by mutableStateOf("")
		private set

	init {
		getMarsPhotos()
	}

	private fun getMarsPhotos() {
		viewModelScope.launch {
			marsUiState = try {
				MarsApi.retrofitService.getPhotos()
			} catch (e: IOException) {
				"Could not fetch data from the server at this time. Try checking your internet connection."
			}
		}
	}
}