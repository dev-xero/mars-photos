package dev.xero.marsphotos.data

import dev.xero.marsphotos.api.MarsApi
import dev.xero.marsphotos.api.MarsApiServiceInterface
import dev.xero.marsphotos.api.MarsPhoto

class MarsPhotoImplementation(
	private val marsApiService: MarsApiServiceInterface
) : MarsPhotoRepository {
	override suspend fun getPhotos(): List<MarsPhoto> {
		return marsApiService.getPhotos()
	}
}