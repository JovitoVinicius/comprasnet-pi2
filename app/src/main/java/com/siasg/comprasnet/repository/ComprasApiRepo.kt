package com.siasg.comprasnet.repository

import com.siasg.comprasnet.di.ComprasApiService
import javax.inject.Inject

class ComprasApiRepo @Inject constructor(
    private val service: ComprasApiService
){

    suspend fun loadData() = service.searchContrato()._embedded

}

