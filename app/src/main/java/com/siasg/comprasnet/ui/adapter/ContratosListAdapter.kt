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
        //holder.color.setBackgroundColor(Color.parseColor(setDateColor(holder.binding.contrato!!.data_assinatura)))
        holder.binding.contrato = contrato
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = listaContratos.size
}

class ContratosViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val binding: ListResultadosBinding = ListResultadosBinding.bind(v)
    val color: ImageView = v.findViewById(R.id.colorCard)
}