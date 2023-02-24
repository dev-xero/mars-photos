package dev.xero.marsphotos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.xero.marsphotos.R

@Composable
fun ErrorScreen(
	modifier: Modifier = Modifier
) {
	Box(
		modifier = modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Text(text = stringResource(id = R.string.loading_failed))
	}
}