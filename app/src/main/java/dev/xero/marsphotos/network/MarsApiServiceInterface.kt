package dev.xero.marsphotos.network

import retrofit2.http.GET

interface MarsApiServiceInterface {
	@GET("photos")
	fun getPhotos(): String
}