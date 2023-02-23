package dev.xero.marsphotos.network

import retrofit2.http.GET

interface MarsApiServiceInterface {
	@GET("photos")
	suspend fun getPhotos(): String
}