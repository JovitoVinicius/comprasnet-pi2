package com.siasg.comprasnet.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.ListResultadosBinding
import com.siasg.comprasnet.domain.ContratoDados
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter


class ContratosListAdapter(
    private val listaContratos: List<ContratoDados>
) : RecyclerView.Adapter<ContratosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContratosViewHolder {
        val template = LayoutInflater.from(parent.context).inflate(
            R.layout.list_resultados,
            parent,
            false
        )
        return ContratosViewHolder(template)
    }

    override fun onBindViewHolder(holder: ContratosViewHolder, position: Int) {
        val contrato = listaContratos[position]
        //holder.color.setBackgroundColor(Color.parseColor(setDateColor(holder.binding.contrato!!.data_assinatura)))
        holder.binding.contrato = contrato
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = listaContratos.size
}

class ContratosViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val binding: ListResultadosBinding = ListResultadosBinding.bind(v)
    //val color: ImageView = v.findViewById(R.id.colorCard)
}

fun setDateColor(string: String): String {
    val date_contrato = LocalDate.parse(string, DateTimeFormatter.ISO_DATE)
    val date_hoje = LocalDateTime.now().toLocalDate()
    val period = Period.between(date_contrato, date_hoje)
    val days_elapsed = period.getDays()

    if (days_elapsed < 30) {
        return "#E16556"
    } else if (days_elapsed >= 30 && days_elapsed < 60) {
        return "#FF7701"
    } else if (days_elapsed >= 60 && days_elapsed < 90) {
        return "#F6B651"
    } else if (days_elapsed >= 90 && days_elapsed < 180) {
        return "#0DCBFA"
    } else (days_elapsed >= 180)
    return "#0081CF"
}