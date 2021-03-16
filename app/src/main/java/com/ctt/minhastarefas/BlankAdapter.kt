package com.ctt.minhastarefas

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.activities.MainActivity
import com.ctt.minhastarefas.model.Tarefa

class BlankAdapter(private val listaFinal: MutableList<Tarefa>) : RecyclerView.Adapter<BlankAdapter.BlankHolder>(){

    //PRIMEIRO PASSO A SER LIDO
    //Item final a ser visualizado e inserido na RecyclerView
    class BlankHolder(view: View) : RecyclerView.ViewHolder(view){
        val nomeTarefa: TextView = view.findViewById(R.id.txtTituloTarefa)
        val descTarefa: TextView = view.findViewById(R.id.txtDescTarefa)
        val changeToProgresso: ImageButton = view.findViewById(R.id.tarefaToProgress)
        val changeToFinal: ImageButton = view.findViewById(R.id.tarefaToFinal)
    }

    fun adicionarTarefa(novaTarefa: Tarefa){

        listaFinal.add(novaTarefa)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlankHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.fragment_tarefas_list, parent, false)

        return BlankHolder(view)
    }

    //Responsável por VINCULAR os dados com os componentes do xml
    //Contato da lista = texto de contato do xml
    override fun onBindViewHolder(holder: BlankHolder, position: Int) {

        holder.nomeTarefa.text = listaFinal[position].nomeTarefa
        holder.descTarefa.text = listaFinal[position].descricaoTarefa
        holder.changeToProgresso.visibility = View.INVISIBLE
        holder.changeToFinal.visibility = View.INVISIBLE

    }

    override fun getItemCount(): Int = listaFinal.size

    fun removeAt(position: Int) {
        listaFinal.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getElement(position: Int): Tarefa {
        return listaFinal[position]

    }
}