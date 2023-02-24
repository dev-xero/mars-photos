package dev.xero.marsphotos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.xero.marsphotos.R
import dev.xero.marsphotos.ui.theme.MarsPhotosTheme

@Composable
fun HomeScreen(
	marsUiState: MarsUiState,
	modifier: Modifier = Modifier
) {

	when (marsUiState) {
		is MarsUiState.Success -> ResultScreen(
			marsUiState = marsUiState,
			modifier = modifier
		)
		is MarsUiState.Loading -> LoadingScreen()
		is MarsUiState.Error -> ErrorScreen()
	}
}

@Composable
fun ResultScreen(
	marsUiState: MarsUiState.Success,
	modifier: Modifier = Modifier
) {

	Box(
		contentAlignment = Alignment.Center,
		modifier = modifier.fillMaxSize(),
	) {

		Text(text = marsUiState.photos)
	}
}