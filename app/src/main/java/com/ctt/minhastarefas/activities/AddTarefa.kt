package com.ctt.minhastarefas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.model.Tarefa

class AddTarefa : AppCompatActivity() {

    lateinit var botaoInsert: Button
    lateinit var tarefa: EditText
    lateinit var descricao: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tarefa)

        botaoInsert = findViewById(R.id.btnAddTarefa)
        tarefa = findViewById(R.id.edtAddTarefa)
        descricao = findViewById(R.id.edtDescrTarefa)

        botaoInsert.setOnClickListener {

            val tarefaDigitado = tarefa.text.toString()
            val descricaoDigitada = descricao.text.toString()


            if(tarefaDigitado.isEmpty()){
                tarefa.error = "Ops... Você precisa preencher esse campo"
            }else{
                val tarefas =  Tarefa(nomeTarefa = tarefaDigitado, descricaoTarefa = descricaoDigitada)
                redirecionar(tarefas)

            }


        }

    }

    fun redirecionar(tarefas: Tarefa){


        val destinoActivity = Intent(this, MainActivity::class.java)
        //android não entende a classe que vc cria precisa criar uma função parcelable
        //pra ele entender que é uma classe q vc criou

        MainActivity.listaTarefas.add(tarefas)

        startActivity(destinoActivity)

    }
}