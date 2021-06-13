package com.siasg.comprasnet.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.siasg.comprasnet.domain.ChatbotDTO
import com.siasg.comprasnet.domain.DialogflowRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

open class RetrofitInitialize(context: Context, baseUrl: String) {
    val retrofit: Retrofit
    private val gson: Gson

    init {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .build()

        gson = GsonBuilder().create()

        retrofit = Retrofit.Builder()
            //.client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}

interface ChatbotService {
    @POST("api/message/text/send")
    @Headers("Content-Type: application/json")
    fun sendText(
        @Body send: DialogflowRequest
    ): Call<List<ChatbotDTO>>
}

class ChatbotRepository (context: Context, url: String) : RetrofitInitialize(context, url) {
    private val service = retrofit.create(ChatbotService::class.java)

    fun sendText(request: DialogflowRequest, callback: (String) -> Unit) {
        service.sendText(request).enqueue(object : Callback<List<ChatbotDTO>> {
            override fun onFailure(call: Call<List<ChatbotDTO>>, t: Throwable) {
                callback("ERROR")
            }

            override fun onResponse(
                call: Call<List<ChatbotDTO>>,
                response: Response<List<ChatbotDTO>>
            ) {
                val list = response.body()

                list?.forEach { dto ->
                    dto.queryResult?.fulfillmentText?.let { callback(it) }
                }
            }

        })
    }
}