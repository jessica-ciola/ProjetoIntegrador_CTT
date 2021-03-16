package com.ctt.minhastarefas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ctt.minhastarefas.activities.MainActivity
import com.ctt.minhastarefas.fragments.BlankFragment
import com.ctt.minhastarefas.fragments.ProgressoFragment
import com.ctt.minhastarefas.fragments.TarefasFragment

class PageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    //Equivalente ao ItemCount da RV
    //Numero de Fragmentos a serem colocados

    override fun getCount(): Int {
        return 3
    }

    //Relacao entre Item/Posicao a fragment a ser exibida

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> TarefasFragment(MainActivity.listaTarefas)
            1 -> ProgressoFragment(MainActivity.listaTarefasProgresso)
            2 -> BlankFragment(MainActivity.listaTarefasFinal)
            else -> BlankFragment(MainActivity.listaTarefasFinal)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "A Fazer"
            1 -> "Em Progresso"
            2 -> "Feitas"

            else -> super.getPageTitle(position)
        }

    }
}