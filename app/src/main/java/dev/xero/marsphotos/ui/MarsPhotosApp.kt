package dev.xero.marsphotos.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.xero.marsphotos.R
import dev.xero.marsphotos.ui.screens.HomeScreen
import dev.xero.marsphotos.ui.screens.MarsViewModel

@Composable
fun MarsPhotosApp() {

	Scaffold(
		topBar = {
			TopAppBar(
				title = {
					Text(
						text = stringResource(id = R.string.app_name)
					)
				}
			)
		}
	) {
		Surface(
			modifier = Modifier
				.padding(it)
				.fillMaxSize(),
			color = MaterialTheme.colors.background
		) {
			val marsViewModel: MarsViewModel = viewModel()

			HomeScreen(marsUiState = marsViewModel.marsUiState)
		}
	}
}