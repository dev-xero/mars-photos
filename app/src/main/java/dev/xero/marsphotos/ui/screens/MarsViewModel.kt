package dev.xero.marsphotos.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.xero.marsphotos.network.MarsApi
import kotlinx.coroutines.launch

class MarsViewModel: ViewModel() {
	var marsUiState: String by mutableStateOf("")
		private set

	init {
		getMarsPhotos()
	}

	private fun getMarsPhotos() {
		viewModelScope.launch {
			marsUiState = MarsApi.retrofitService.getPhotos()
		}
	}
}