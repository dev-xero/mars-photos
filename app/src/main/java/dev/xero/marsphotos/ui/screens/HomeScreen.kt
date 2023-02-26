package dev.xero.marsphotos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
		is MarsUiState.Success -> PhotoGrid(photos = marsUiState.photos)
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
			.error(R.drawable.ic_broken_image)
			.build(),
		contentDescription = stringResource(id = R.string.mars_photo),
		contentScale = ContentScale.FillBounds
	)
}

@Composable
fun PhotoGrid(
	photos: List<MarsPhoto>,
	modifier: Modifier = Modifier
) {
	LazyVerticalGrid(
		columns = GridCells.Adaptive(150.dp),
		modifier = Modifier.fillMaxWidth(),
		contentPadding = PaddingValues(4.dp)
	) {
		items(items = photos, key = { photo -> photo.id }) {
			photo -> MarsPhotoCard(photo = photo)
		}
	}
}