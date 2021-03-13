package com.ctt.minhastarefas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.viewpager.widget.ViewPager
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.TarefasAdapter
import com.ctt.minhastarefas.activities.MainActivity
import com.ctt.minhastarefas.model.SwipeToDeleteCallback
//import com.ctt.minhastarefas.TarefasFragment.Companion.listaTarefa
import com.ctt.minhastarefas.model.Tarefa
import com.google.android.material.tabs.TabLayout

lateinit var listaTarefas: MutableList<Tarefa>

class TarefasFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tarefas, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagem = view.findViewById<ImageView>(R.id.imgvaziotarefas)
        val texto1 = view.findViewById<TextView>(R.id.txtTextoVaziotarefas)
        val texto2 = view.findViewById<TextView>(R.id.txtTextoVazio2tarefas)


        val rvTarefas = view.findViewById<RecyclerView>(R.id.listaTarefasItem)

        val adapterTarefas = TarefasAdapter(MainActivity.listaTarefas)
        rvTarefas.adapter = adapterTarefas

        rvTarefas.layoutManager = LinearLayoutManager(requireContext())

        if(MainActivity.listaTarefas.isEmpty()){
            imagem.visibility = View.VISIBLE
            texto1.visibility = View.VISIBLE
            texto2.visibility = View.VISIBLE


        }else{

            imagem.visibility = View.GONE
            texto1.visibility = View.GONE
            texto2.visibility = View.GONE

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