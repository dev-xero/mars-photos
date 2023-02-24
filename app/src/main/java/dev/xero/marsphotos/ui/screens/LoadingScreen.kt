package dev.xero.marsphotos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.xero.marsphotos.R
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		var rotationState by remember { mutableStateOf(0f) }
		LaunchedEffect(Unit) {
			while (true) {
				delay(16)
				rotationState = (rotationState + 4f) % 360f
			}
		}

		Image(
			modifier = Modifier
				.size(200.dp)
				.rotate(rotationState),
			painter = painterResource(id = R.drawable.loading_img),
			contentDescription = stringResource(id = R.string.loading)
		)
	}
}