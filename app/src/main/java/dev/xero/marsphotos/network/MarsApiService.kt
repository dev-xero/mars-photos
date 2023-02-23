package dev.xero.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
	.addConverterFactory(ScalarsConverterFactory.create())
	.baseUrl(BASE_URL)
	.build()

object MarsApi {
	val retrofitService: MarsApiServiceInterface by lazy {
		retrofit.create(MarsApiServiceInterface::class.java)
	}
}
