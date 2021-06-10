package com.siasg.comprasnet.di

import com.google.gson.Gson
import com.siasg.comprasnet.domain.ResultsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.io.FileReader


@Module
@InstallIn(SingletonComponent::class)
class ComprasApiModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://compras.dados.gov.br/contratos/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesComprasService(retrofit: Retrofit): ComprasApiService {
        return retrofit.create(ComprasApiService::class.java)
    }

}

interface ComprasApiService {
    @GET("contratos.json?uasg=20001&order_by=uasg&order=desc")
    @Headers("Content-Type: application/json")
    suspend fun searchContrato(): ResultsApi
}