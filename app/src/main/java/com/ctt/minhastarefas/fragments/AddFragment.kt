package com.ctt.minhastarefas.fragments//package com.ctt.minhastarefas
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import androidx.recyclerview.widget.RecyclerView
//
//
//
//class AddFragment : Fragment() {
//
//    lateinit var botaoInsert: Button
//    lateinit var tarefa: EditText
//    lateinit var descricao: EditText
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add, container, false)
//
//    }
//
//    override fun onStart() {
//        super.onStart()
//        botaoInsert = view.findViewById(R.id.btnAddTarefa)
//        tarefa = view.findViewById(R.id.edtAddTarefa)
//        descricao = view.findViewById(R.id.edtDescrTarefa)
//
//        botaoInsert.setOnClickListener {
//
//            val nomeDigitado = edtNomeUsuario.text.toString()
//            val idadeDigitada = idadeUsuario.text.toString()
//
//
//            if(nomeDigitado.isEmpty()){
//                if(idadeDigitada.isEmpty()){
//                    idadeUsuario.error = "Você ainda não nasceu?"
//                } else{
//                    edtNomeUsuario.error = "Não existe nome vazio, né?"}
//            }else{
//                val usuario =  Usuario(++contador, nomeDigitado, idadeDigitada.toInt(),foto)
//                exibirUsuario(usuario)
//
//            }
//
//            val telaList = Intent(this, MainActivity::class.java)
//            telaList.putExtra("wish", wish.text)
//            wish.setText("")
//            wish.requestFocus()
//            startActivity(telaList)
//
//
//        }
//    }
//
//
//
//
//    companion object {
//    }
//}