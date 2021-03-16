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

class ProgressoAdapter(private val listaProgresso: MutableList<Tarefa>) : RecyclerView.Adapter<ProgressoAdapter.ProgressoHolder>(){

    //PRIMEIRO PASSO A SER LIDO
    //Item final a ser visualizado e inserido na RecyclerView
    class ProgressoHolder(view: View) : RecyclerView.ViewHolder(view){
        val nomeTarefa: TextView = view.findViewById(R.id.txtTituloTarefa)
        val descTarefa: TextView = view.findViewById(R.id.txtDescTarefa)
        val changeToProgresso: ImageButton = view.findViewById(R.id.tarefaToProgress)
        val changeToFinal: ImageButton = view.findViewById(R.id.tarefaToFinal)
    }

    fun adicionarTarefa(novaTarefa: Tarefa){

        listaProgresso.add(novaTarefa)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressoHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.fragment_tarefas_list, parent, false)

        return ProgressoHolder(view)
    }

    //Responsável por VINCULAR os dados com os componentes do xml
    //Contato da lista = texto de contato do xml
    override fun onBindViewHolder(holder: ProgressoHolder, position: Int) {

        holder.nomeTarefa.text = listaProgresso[position].nomeTarefa
        holder.descTarefa.text = listaProgresso[position].descricaoTarefa
        holder.changeToProgresso.visibility = View.INVISIBLE


        holder.changeToFinal.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Tarefa " + holder.nomeTarefa.text)
            builder.setMessage("Esta Tarefa está em andamento?")
            builder.setPositiveButton("Sim") { dialog, which ->

                MainActivity.listaTarefasFinal.add(listaProgresso[position])
                val adapterTarefas = BlankAdapter(MainActivity.listaTarefasFinal)
                adapterTarefas.notifyDataSetChanged()

                listaProgresso.removeAt(position)
                notifyDataSetChanged()
            }
            builder.setNegativeButton("Não") { dialog, which -> }

            val dialog: AlertDialog = builder.create()
            dialog.show()

        }
    }

    override fun getItemCount(): Int = listaProgresso.size

    fun removeAt(position: Int) {
        listaProgresso.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getElement(position: Int):Tarefa{
        return listaProgresso[position]

    }
}




