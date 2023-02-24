package dev.xero.marsphotos

import android.app.Application
import dev.xero.marsphotos.data.AppContainer
import dev.xero.marsphotos.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
	lateinit var container: AppContainer
	override fun onCreate() {
		super.onCreate()
		container = DefaultAppContainer()
	}
}