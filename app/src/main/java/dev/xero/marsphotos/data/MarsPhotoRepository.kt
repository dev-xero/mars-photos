package dev.xero.marsphotos.data

import dev.xero.marsphotos.api.MarsPhoto

interface MarsPhotoRepository {
	suspend fun getPhotos():
		List<MarsPhoto>
}