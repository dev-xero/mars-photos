package dev.xero.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
	.addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
	.baseUrl(BASE_URL)
	.build()

object MarsApi {
	val retrofitService: MarsApiServiceInterface by lazy {
		retrofit.create(MarsApiServiceInterface::class.java)
	}
}
