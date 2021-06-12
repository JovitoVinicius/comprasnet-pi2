package com.siasg.comprasnet.repository

import android.content.Context
import com.siasg.comprasnet.di.ComprasApiService
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class ComprasApiRepo @Inject constructor(
    private val service: ComprasApiService
){

    suspend fun loadData() = service.searchContrato()._embedded

}

