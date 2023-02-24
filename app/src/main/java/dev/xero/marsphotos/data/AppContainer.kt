package dev.xero.marsphotos.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.xero.marsphotos.api.MarsApiServiceInterface
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

interface AppContainer {
	val marsPhotoRepository: MarsPhotoRepository
}

class DefaultAppContainer : AppContainer {
	private val baseURL = "https://android-kotlin-fun-mars-server.appspot.com"

	private val retrofit = Retrofit.Builder()
		.addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
		.baseUrl(baseURL)
		.build()

	private val marsApiService: MarsApiServiceInterface by lazy {
		retrofit.create(MarsApiServiceInterface::class.java)
	}

	override val marsPhotoRepository: MarsPhotoRepository by lazy {
		MarsPhotoImplementation(marsApiService)
	}
}