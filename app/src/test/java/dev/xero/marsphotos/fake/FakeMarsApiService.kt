package dev.xero.marsphotos.fake

import dev.xero.marsphotos.api.MarsApiServiceInterface
import dev.xero.marsphotos.api.MarsPhoto

class FakeMarsApiService : MarsApiServiceInterface {
	override suspend fun getPhotos(): List<MarsPhoto> {
		return FakeDataSource.photoList
	}
}