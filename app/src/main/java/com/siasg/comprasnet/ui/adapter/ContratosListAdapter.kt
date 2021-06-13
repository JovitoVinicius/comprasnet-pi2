package com.siasg.comprasnet.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        holder.color.setBackgroundResource((setDateColor(holder.binding.contrato!!.data_termino_vigencia)))
        holder.binding.contrato = contrato
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = listaContratos.size
}

class ContratosViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val binding: ListResultadosBinding = ListResultadosBinding.bind(v)
    val color: ImageView = v.findViewById(R.id.colorCard)
}

fun setDateColor(string: String): Int {
    val date_contrato = LocalDate.parse(string, DateTimeFormatter.ISO_DATE).toEpochDay()
    val date_hoje = LocalDateTime.now().toLocalDate().toEpochDay()
    val days = (date_hoje - date_contrato)
    val days_elapsed = Math.abs(days)

    return when {
        days_elapsed < 30 -> R.color.red_vencem_30dias
        days_elapsed in 30..59 -> R.color.orange_vencem_30_60
        days_elapsed in 60..89 -> R.color.yellow_vencem_60_90
        days_elapsed in 90..179 -> R.color.blue_vencem_90_180
        else -> R.color.blue_vencem_180
    }
}