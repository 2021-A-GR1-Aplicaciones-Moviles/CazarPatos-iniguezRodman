package com.iniguezrodman.cazarpatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RankingAdapter(private val dataSet: ArrayList<Jugador>) : RecyclerView.Adapter<RankingAdapter.ViewHolder>()  {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewPosicion: TextView
        val textViewPatosCazados: TextView
        val textViewUsuario: TextView
        init {
            textViewPosicion = view.findViewById(R.id.textViewPosicion)
            textViewPatosCazados = view.findViewById(R.id.textViewPatosCazados)
            textViewUsuario = view.findViewById(R.id.textViewUsuario)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ranking_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RankingAdapter.ViewHolder, position: Int) {
        val posicion = position + 1
        holder.textViewPosicion.text = position.toString()
        holder.textViewPatosCazados.text = dataSet[position].patosCazados.toString()
        holder.textViewUsuario.text = dataSet[position].usuario
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}