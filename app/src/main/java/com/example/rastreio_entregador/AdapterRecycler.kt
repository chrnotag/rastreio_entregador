package com.example.rastreio_entregador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterRecycler(var listaArquivos: Array<String>): RecyclerView.Adapter<AdapterRecycler.viewHolder>(){

    inner class viewHolder(itemview: View): ViewHolder(itemview){
        var name: TextView
        var endereco: TextView
        var layout: LinearLayout
        init {
            name = itemview.findViewById(R.id.name_file)
            endereco = itemview.findViewById(R.id.Endereco)
            layout = itemview.findViewById(R.id.layout_endereco)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_recycler_layout, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.name.text = listaArquivos[position]
        holder.itemView.setOnClickListener {

            holder.itemView.context.openFileInput(listaArquivos[position]).bufferedReader().useLines { lines ->
                var teste = lines.fold("Endereço: ") { some, text ->
                    "$some\n$text"
                }
                when(holder.layout.visibility){
                    View.VISIBLE -> {
                        holder.layout.visibility = View.GONE
                    }
                    View.GONE -> {
                        holder.endereco.text = teste
                        holder.layout.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = listaArquivos.size

}