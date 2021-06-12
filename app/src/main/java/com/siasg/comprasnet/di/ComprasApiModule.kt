package com.siasg.comprasnet.di

import com.siasg.comprasnet.domain.ResultsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.ArrayList


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
    @GET("contratos.json?")
    @Headers("Content-Type: application/json")
    suspend fun searchContrato(): ResultsApi
}