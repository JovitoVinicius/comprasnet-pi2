package com.siasg.comprasnet.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.siasg.comprasnet.domain.ContratoDados
import com.siasg.comprasnet.domain.ResultsApi
import com.siasg.comprasnet.interactor.ComprasApiInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComprasApiViewModel @Inject constructor(
    app: Application,
    private val interactor: ComprasApiInteractor
) : AndroidViewModel(app) {

    val resultado = MutableLiveData<List<ContratoDados>>()

    fun loadData() {

        viewModelScope.launch {
            resultado.value = interactor.loadData().contratos
        }

    }

}