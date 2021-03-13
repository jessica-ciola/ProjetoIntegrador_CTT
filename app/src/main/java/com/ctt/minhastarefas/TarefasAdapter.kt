package com.ctt.minhastarefas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.model.Tarefa

class TarefasAdapter(private val listaTarefas: MutableList<Tarefa>) : RecyclerView.Adapter<TarefasAdapter.TarefasHolder>(){

    //PRIMEIRO PASSO A SER LIDO
    //Item final a ser visualizado e inserido na RecyclerView
    class TarefasHolder(view: View) : RecyclerView.ViewHolder(view){
        val nomeTarefa: TextView = view.findViewById(R.id.txtTituloTarefa)
        val descTarefa: TextView = view.findViewById(R.id.txtDescTarefa)
    }

    fun adicionarTarefa(novaTarefa: Tarefa){

        listaTarefas.add(novaTarefa)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefasHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.fragment_tarefas_list, parent, false)

        return TarefasHolder(view)
    }

    //Responsável por VINCULAR os dados com os componentes do xml
    //Contato da lista = texto de contato do xml
    override fun onBindViewHolder(holder: TarefasHolder, position: Int) {

        holder.nomeTarefa.text = listaTarefas[position].nomeTarefa
        holder.descTarefa.text = listaTarefas[position].descricaoTarefa

    }

    override fun getItemCount(): Int = listaTarefas.size

    fun removeAt(position: Int) {
        listaTarefas.removeAt(position)
        notifyItemRemoved(position)
    }

}