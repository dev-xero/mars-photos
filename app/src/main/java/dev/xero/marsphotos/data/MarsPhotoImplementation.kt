package dev.xero.marsphotos.data

import dev.xero.marsphotos.api.MarsApi
import dev.xero.marsphotos.api.MarsPhoto

class MarsPhotoImplementation : MarsPhotoRepository {
	override suspend fun getPhotos(): List<MarsPhoto> {
		return MarsApi.marsApiService.getPhotos()
	}
}