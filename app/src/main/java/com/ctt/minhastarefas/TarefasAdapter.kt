package com.ctt.minhastarefas

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.activities.MainActivity
import com.ctt.minhastarefas.model.Tarefa

class TarefasAdapter(private val listaTarefas: MutableList<Tarefa>) : RecyclerView.Adapter<TarefasAdapter.TarefasHolder>(){

    //PRIMEIRO PASSO A SER LIDO
    //Item final a ser visualizado e inserido na RecyclerView
    class TarefasHolder(view: View) : RecyclerView.ViewHolder(view){
        val nomeTarefa: TextView = view.findViewById(R.id.txtTituloTarefa)
        val descTarefa: TextView = view.findViewById(R.id.txtDescTarefa)
        val changeToProgresso: ImageButton = view.findViewById(R.id.tarefaToProgress)
        val changeToFinal: ImageButton = view.findViewById(R.id.tarefaToFinal)
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

//        val item = holder.adapterPosition

        holder.changeToProgresso.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Tarefa " + holder.nomeTarefa.text)
            builder.setMessage("Esta Tarefa está em andamento?")
            builder.setPositiveButton("Sim") { dialog, which ->

                MainActivity.listaTarefasProgresso.add(listaTarefas[position])
                val adapterTarefas = ProgressoAdapter(MainActivity.listaTarefasProgresso)
                adapterTarefas.notifyDataSetChanged()

                listaTarefas.removeAt(position)
                notifyDataSetChanged()
            }
            builder.setNegativeButton("Não") { dialog, which -> }

            val dialog: AlertDialog = builder.create()
            dialog.show()

        }

        holder.changeToFinal.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Tarefa " + holder.nomeTarefa.text)
            builder.setMessage("Esta Tarefa está Finalizada")
            builder.setPositiveButton("Sim") { dialog, which ->

                MainActivity.listaTarefasFinal.add(listaTarefas[position])
                val adapterTarefas = BlankAdapter(MainActivity.listaTarefasFinal)
                adapterTarefas.notifyDataSetChanged()

                listaTarefas.removeAt(position)
                notifyDataSetChanged()
            }
            builder.setNegativeButton("Não") { dialog, which -> }

            val dialog: AlertDialog = builder.create()
            dialog.show()

        }
    }

    override fun getItemCount(): Int = listaTarefas.size

    fun removeAt(position: Int) {
        listaTarefas.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getElement(position: Int):Tarefa{
        return listaTarefas[position]

    }

}