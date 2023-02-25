package dev.xero.marsphotos.fake

import dev.xero.marsphotos.api.MarsPhoto

object FakeDataSource {

	private const val idOne = "img_1"
	private const val idTwo = "img_2"
	private const val imgOne = "url.1"
	private const val imgTwo = "url.2"

	val photoList = listOf<MarsPhoto>(
		MarsPhoto(
			id = idOne,
			imgSrc = imgOne
		),

		MarsPhoto(
			id = idTwo,
			imgSrc = imgTwo
		),
	)
}