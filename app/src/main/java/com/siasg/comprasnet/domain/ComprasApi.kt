package com.siasg.comprasnet.domain

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

data class ResultsApi(
    val _embedded: Embedded,
    val _links: LinksX,
    val count: Int,
    val offset: Int
)

data class Embedded(
    val contratos: List<ContratoDados>
)

data class LinksX(
    val first: First,
    val next: Next,
    val self: SelfX
)

data class ContratoDados(
    val _links: Links,
    val cnpj_contratada: String,
    val codigo_contrato: Int,
    val cpfContratada: Any,
    val data_assinatura: String,
    var color: String,
    val data_inicio_vigencia: String,
    val data_termino_vigencia: String,
    val fundamento_legal: String,
    val identificador: String,
    val licitacao_associada: String,
    val modalidade_licitacao: Int,
    val numero: Int,
    val numero_aditivo: Any,
    val numero_aviso_licitacao: Int,
    val numero_processo: String,
    val objeto: String,
    val origem_licitacao: String,
    val uasg: Int,
    val valor_inicial: Double,
    val nome: String = "${uasg} - ${origem_licitacao}"
)

data class Links(
    val aditivos: Aditivos,
    val apostilamentos: Apostilamentos,
    val eventos: Eventos,
    val fornecedor: Fornecedor,
    val licitacao: Licitacao,
    val modalidade_licitacao: ModalidadeLicitacao,
    val self: Self,
    val tipo_contrato: TipoContrato,
    val uasg: Uasg
)

data class Aditivos(
    val href: String,
    val title: String
)

data class Apostilamentos(
    val href: String,
    val title: String
)

data class Eventos(
    val href: String,
    val title: String
)

data class Fornecedor(
    val href: String,
    val title: String
)

data class Licitacao(
    val href: String,
    val title: String
)

data class ModalidadeLicitacao(
    val href: String,
    val title: String
)

data class Self(
    val href: String,
    val title: String
)

data class TipoContrato(
    val href: String,
    val title: String
)

data class Uasg(
    val href: String,
    val title: String
)

data class First(
    val href: String,
    val title: String
)

data class Next(
    val href: String,
    val title: String
)

data class SelfX(
    val href: String,
    val title: String
)

/**data class ContratoDados (
val cnpj_contratada: String,
val valor_inicial: Int,
val uasg: Int,
val codigo_contrato: Int,
val cpfContratada: String,
val data_assinatura: String,
val data_inicio_vigencia: String,
val data_termino_vigencia: String,
val fundamento_legal: String,
val identificador: String,
val licitacao_associada: String,
val modalidade_licitacao: Int,
val numero: Int,
val numero_aditivo: String,
val numero_aviso_licitacao: Int,
val numero_processo: String,
val objeto: String,
val origem_licitacao: String
)

data class ResultsApi (
val title: String,
val count: Int,
val results: List<ContratoDados>
)**/