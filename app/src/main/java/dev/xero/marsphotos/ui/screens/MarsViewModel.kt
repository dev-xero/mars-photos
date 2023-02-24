package dev.xero.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.xero.marsphotos.data.MarsPhotoImplementation
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MarsUiState {
	object Loading : MarsUiState
	object Error : MarsUiState

	data class Success(val photos: String) : MarsUiState
}

class MarsViewModel: ViewModel() {
	var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
		private set

	init {
		getMarsPhotos()
	}

	private fun getMarsPhotos() {
		viewModelScope.launch {
			marsUiState = try {
				MarsUiState.Success("Success: ${MarsPhotoImplementation().getPhotos().size} Mars Photos retrieved")
			} catch (e: IOException) {
				MarsUiState.Error
			}
		}
	}
}