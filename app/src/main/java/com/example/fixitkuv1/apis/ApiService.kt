package com.example.fixitkuv1.apis



import com.example.fixitkuv1.responses.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("api_fixapp_user_authen.php?fixapp_api=login")
    fun login(
        @Field("nama") usernameL: String?,
        @Field("katasandi") passwordL: String?,
    ): Call<ResponseLoginData>?

    @FormUrlEncoded
    @POST("api_fixapp_user_authen.php?fixapp_api=signup")
    fun signup(
        @Field("nama") nama: String?,
        @Field("email") email: String?,
        @Field("katasandi") katasandi: String?,
        @Field("kelas") kelas: String?,
        @Field("nomorsiswa") nomorsiswa: Int?,
        @Field("tipe") tipe: String?,
    ): Call<ResponseLoginData>?
}