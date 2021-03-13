package com.ctt.minhastarefas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.ctt.minhastarefas.PageAdapter
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.model.Tarefa
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    lateinit var botaoAdd: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        viewPager.adapter = PageAdapter(supportFragmentManager)

        //vinculamos a viewpage ao tabLayout
        tabLayout.setupWithViewPager(viewPager)

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {

            startActivity(Intent(this, AddTarefa::class.java))
        }

    }
    companion object{
        val listaTarefas = mutableListOf<Tarefa>()
    }


}