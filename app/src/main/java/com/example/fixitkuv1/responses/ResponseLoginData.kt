package com.example.fixitkuv1.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseLoginData(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("user")
	val user: User
) : Parcelable

@Parcelize
data class User(

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("nomorsiswa")
	val nomorsiswa: Int,

	@field:SerializedName("kelas")
	val kelas: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("tipe")
	val tipe: String,

	@field:SerializedName("email")
	val email: String
) : Parcelable
