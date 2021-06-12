package com.siasg.comprasnet.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.siasg.comprasnet.R
import com.siasg.comprasnet.ui.fragment.home.ResultLocalFragmentDirections
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class RecyclerAdapter(
    private var context: Context,
    private var codigo_contrato: ArrayList<String> = ArrayList(),
    private var cpfContratada: ArrayList<String> = ArrayList(),
    private var cnpj_contratada: ArrayList<String> = ArrayList(),
    private var data_assinatura: ArrayList<String> = ArrayList(),
    private var data_inicio_vigencia: ArrayList<String> = ArrayList(),
    private var data_termino_vigencia: ArrayList<String> = ArrayList(),
    private var fundamento_legal: ArrayList<String> = ArrayList(),
    private var identificador: ArrayList<String> = ArrayList(),
    private var licitacao_associada: ArrayList<String> = ArrayList(),
    private var modalidade_licitacao: ArrayList<String> = ArrayList(),
    private var numero: ArrayList<String> = ArrayList(),
    private var numero_aditivo: ArrayList<String> = ArrayList(),
    private var numero_aviso_licitacao: ArrayList<String> = ArrayList(),
    private var numero_processo: ArrayList<String> = ArrayList(),
    private var objeto: ArrayList<String> = ArrayList(),
    private var origem_licitacao: ArrayList<String> = ArrayList(),
    private var uasg: ArrayList<String> = ArrayList(),
    private var valor_inicial: ArrayList<String> = ArrayList(),
    private var detalhes: String = ""
) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_resultados, parent, false)
        return MyViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titulo.text = "UASG: ${uasg[position]}"
        holder.subtitulo1.text = "Contrato ID: ${identificador[position]}"
        holder.subtitulo2.text = objeto[position]
        holder.cardColor.setBackgroundResource(setDateColor(data_assinatura[position]))

        holder.itemView.setOnClickListener{ view ->

        }

        holder.itemView.setOnClickListener { view ->
            detalhes = "ID: ${identificador[position]},\n" +
                    "Uasg: ${uasg[position]},\n" +
                    "Modalidade da licitacao: ${modalidade_licitacao[position]},\n" +
                    "Numero de aviso da licitacao: ${numero_aviso_licitacao[position]},\n" +
                    "Código de contrato: ${codigo_contrato[position]},\n" +
                    "Licitação associada: ${licitacao_associada[position]},\n" +
                    "Origem da licitacao: ${origem_licitacao[position]},\n" +
                    "Número: ${numero[position]},\n" +
                    "Objeto: ${objeto[position]},\n" +
                    "Número aditivo: ${numero_aditivo[position]},\n" +
                    "Número processo: ${numero_processo[position]},\n" +
                    "CPF da Contratada: ${cpfContratada[position]},\n" +
                    "Cnpj da contratada: ${cnpj_contratada[position]},\n" +
                    "Data da assinatura: ${data_assinatura[position]},\n" +
                    "Fundamento legal: ${fundamento_legal[position]},\n" +
                    "Data de início de vigência: ${data_inicio_vigencia[position]},\n" +
                    "Data de término de vigência: ${data_termino_vigencia[position]},\n" +
                    "Valor inicial: R$ ${valor_inicial[position]}"

            val action = ResultLocalFragmentDirections.actionResultFragmentToDetailsFragment(detalhes)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return identificador.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titulo: TextView = itemView.findViewById<View>(R.id.card_title) as TextView
        var subtitulo1: TextView = itemView.findViewById<View>(R.id.card_subtitle) as TextView
        var subtitulo2: TextView = itemView.findViewById<View>(R.id.card_subtitle2) as TextView
        var cardColor: ImageView = itemView.findViewById<View>(R.id.colorCard) as ImageView
    }

    fun returnDetalhes(detalhes: String): String {
        return detalhes
    }

    fun setDateColor(string: String): Int {
        val date_contrato = LocalDate.parse(string, DateTimeFormatter.ISO_DATE).toEpochDay()
        val date_hoje = LocalDateTime.now().toLocalDate().toEpochDay()
        val days_elapsed = date_hoje - date_contrato

        return when {
            days_elapsed < 30 -> R.color.red_vencem_30dias
            days_elapsed in 30..59 -> R.color.orange_vencem_30_60
            days_elapsed in 60..89 -> R.color.yellow_vencem_60_90
            days_elapsed in 90..179 -> R.color.blue_vencem_90_180
            else -> R.color.blue_vencem_180
        }
    }
}

