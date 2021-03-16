package com.ctt.minhastarefas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.minhastarefas.ProgressoAdapter
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.TarefasAdapter
import com.ctt.minhastarefas.activities.MainActivity
import com.ctt.minhastarefas.model.SwipeToDeleteCallback
import com.ctt.minhastarefas.model.Tarefa


class ProgressoFragment(listaProgresso: MutableList<Tarefa>) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progresso, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagem = view.findViewById<ImageView>(R.id.imgvaziotarefas)
        val texto1 = view.findViewById<TextView>(R.id.txtTextoVaziotarefas)
        val texto2 = view.findViewById<TextView>(R.id.txtTextoVazio2tarefas)


        val rvTarefas = view.findViewById<RecyclerView>(R.id.listaProgresso)

        val adapterTarefas = ProgressoAdapter(MainActivity.listaTarefasProgresso)
        rvTarefas.adapter = adapterTarefas

        rvTarefas.layoutManager = LinearLayoutManager(requireContext())

        if(MainActivity.listaTarefasProgresso.isEmpty()){
            imagem.visibility = View.VISIBLE
            texto1.visibility = View.VISIBLE
            texto2.visibility = View.VISIBLE


        }else{

            imagem.visibility = View.INVISIBLE
            texto1.visibility = View.INVISIBLE
            texto2.visibility = View.INVISIBLE

        }

        val swipeHandler = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                adapterTarefas.removeAt(viewHolder.adapterPosition)
            }

        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rvTarefas)

    }




}