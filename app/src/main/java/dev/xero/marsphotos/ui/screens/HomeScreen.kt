package dev.xero.marsphotos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.xero.marsphotos.R
import dev.xero.marsphotos.api.MarsPhoto

@Composable
fun HomeScreen(
	marsUiState: MarsUiState,
	modifier: Modifier = Modifier
) {

	when (marsUiState) {
		is MarsUiState.Success -> MarsPhotoCard(photo = marsUiState.photos)
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

	// Text(text = marsUiState.photos)
	}
}

@Composable
fun MarsPhotoCard(
	photo: MarsPhoto,
	modifier: Modifier = Modifier
) {
	AsyncImage(
		model = ImageRequest
			.Builder(context = LocalContext.current)
			.data(photo.imgSrc)
			.crossfade(true)
			.build(),
		contentDescription = stringResource(id = R.string.mars_photo)
	)
}