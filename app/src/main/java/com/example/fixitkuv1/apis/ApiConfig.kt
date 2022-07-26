package com.fakkaru.seani.apis

import com.example.fixitkuv1.BuildConfig
import com.example.fixitkuv1.apis.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    class ApiConfig {
        companion object{
            fun getApiService(): ApiService {
                val loggingInterceptor = if(BuildConfig.DEBUG) {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                }else {
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
                }

                //.addInterceptor(loggingInterceptor)
                val client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor { chain ->
                        val original = chain.request()

                        // Request customization: add request headers
                        val requestBuilder = original.newBuilder()
                        //.header("Authorization", BuildConfig.githubuserv3_key) // <-- this is the important line
                        val request = requestBuilder.build()
                        chain.proceed(request)
                    }
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://seaniv1.000webhostapp.com/api_fixapp/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                return retrofit.create(ApiService::class.java)
            }
        }
    }
}
