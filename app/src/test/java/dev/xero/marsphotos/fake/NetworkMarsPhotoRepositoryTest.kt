package dev.xero.marsphotos.fake

import dev.xero.marsphotos.data.MarsPhotoImplementation
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkMarsPhotoRepositoryTest {

	@OptIn(ExperimentalCoroutinesApi::class)
	@Test
	fun networkMarsPhotoRepositoryTest_getMarsPhotos_verifyPhotosList() = runTest {
		val repository = MarsPhotoImplementation(
			marsApiService = FakeMarsApiService()
		)
		assertEquals(FakeDataSource.photoList, repository.getPhotos())
	}
}