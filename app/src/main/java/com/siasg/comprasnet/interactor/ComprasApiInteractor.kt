package com.siasg.comprasnet.interactor

import com.siasg.comprasnet.domain.ContratoDados
import com.siasg.comprasnet.domain.Embedded
import com.siasg.comprasnet.domain.ResultsApi
import com.siasg.comprasnet.repository.ComprasApiRepo
import javax.inject.Inject


class ComprasApiInteractor @Inject constructor(
    private val repo: ComprasApiRepo
) {

    suspend fun loadData(): Embedded {
        return repo.loadData()
    }
}