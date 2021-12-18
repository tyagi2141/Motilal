package com.example.motilal.util

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommonResponseModel<T : Parcelable>(
	@SerializedName("ResponseData")
	var responseData: T? = null,
	@SerializedName("Error")
	var error: Error? = null,
	@SerializedName("ResponseStatus")
	var responseStatus: Int? = null, // 500
	@SerializedName("success")
	var success: Boolean = false // false
) : Parcelable {
	@Parcelize
	data class Error(
		@SerializedName("ErrorCause")
		var ErrorCause: String? = null, // Null
		@SerializedName("ErrorMessage")
		var ErrorMessage: String? = null, //
		@SerializedName("ErrorTrace")
		var errorTrace: String? = null,
		@SerializedName("MessageToUser")
		var messageToUser: String = "Something went wrong, please try again" // Something went wrong, please try again
	) : Parcelable
}
