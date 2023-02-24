package dev.xero.marsphotos.data

import dev.xero.marsphotos.network.MarsPhoto

interface MarsPhotoRepository {
	suspend fun getPhotos():
		List<MarsPhoto>
}