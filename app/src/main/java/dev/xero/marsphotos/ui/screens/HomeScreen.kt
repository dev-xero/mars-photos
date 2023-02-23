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
	marsUiState: String,
	modifier: Modifier = Modifier
) {

	ResultScreen(
		marsUiState = marsUiState,
		modifier = modifier
	)
}

@Composable
fun ResultScreen(
	marsUiState: String,
	modifier: Modifier = Modifier
) {

	Box(
		contentAlignment = Alignment.Center,
		modifier = modifier.fillMaxSize(),
	) {

		Text(text = marsUiState)
	}
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
	MarsPhotosTheme {
		ResultScreen(stringResource(R.string.placeholder_result))
	}
}