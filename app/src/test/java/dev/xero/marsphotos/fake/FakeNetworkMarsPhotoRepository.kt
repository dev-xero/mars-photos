package dev.xero.marsphotos.fake

import dev.xero.marsphotos.api.MarsPhoto
import dev.xero.marsphotos.data.MarsPhotoRepository

class FakeNetworkMarsPhotoRepository : MarsPhotoRepository {
	override suspend fun getPhotos(): List<MarsPhoto> {
		return FakeDataSource.photoList
	}
}