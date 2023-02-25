package dev.xero.marsphotos.fake

import dev.xero.marsphotos.ui.screens.MarsUiState
import dev.xero.marsphotos.ui.screens.MarsViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class MarsViewModelTest {

	@OptIn(ExperimentalCoroutinesApi::class)
	@Test
	fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest {
		val marsViewModel = MarsViewModel(
			marsPhotoRepository = FakeNetworkMarsPhotoRepository()
		)
		assertEquals(
			MarsUiState.Success("Success: ${FakeDataSource.photoList.size} Mars Photos retrieved"),
			marsViewModel.marsUiState
		)
	}
}