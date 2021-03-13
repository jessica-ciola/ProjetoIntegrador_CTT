package com.ctt.minhastarefas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ctt.minhastarefas.fragments.BlankFragment
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
            0 -> TarefasFragment()
            1 -> BlankFragment()
            2 -> BlankFragment()
            else -> BlankFragment()
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