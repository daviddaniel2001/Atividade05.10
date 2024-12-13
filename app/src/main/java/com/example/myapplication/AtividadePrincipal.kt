package com.example.myapplication


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoNome = findViewById<EditText>(R.id.etNome)
        val campoCPF = findViewById<EditText>(R.id.etCPF)
        val campoEstado = findViewById<EditText>(R.id.etEstado)
        val campoCidade = findViewById<EditText>(R.id.etCidade)
        val checkJava = findViewById<CheckBox>(R.id.cbJava)
        val checkPHP = findViewById<CheckBox>(R.id.cbPHP)
        val checkCSharp = findViewById<CheckBox>(R.id.cbCSharp)
        val grupoParadigma = findViewById<RadioGroup>(R.id.rgParadigma)
        val botaoCancelar = findViewById<Button>(R.id.btnCancelar)
        val botaoSalvar = findViewById<Button>(R.id.btnSalvar)

        botaoSalvar.setOnClickListener {
            val nome = campoNome.text.toString()
            val cpf = campoCPF.text.toString()
            val estado = campoEstado.text.toString()
            val cidade = campoCidade.text.toString()

            val linguagensEscolhidas = mutableListOf<String>()
            if (checkJava.isChecked) linguagensEscolhidas.add("JAVA")
            if (checkPHP.isChecked) linguagensEscolhidas.add("PHP")
            if (checkCSharp.isChecked) linguagensEscolhidas.add("C#")

            val paradigmaSelecionado = when (grupoParadigma.checkedRadioButtonId) {
                R.id.rbProcedural -> "Procedural"
                R.id.rbPOO -> "POO"
                else -> "Nenhum"
            }

            Toast.makeText(
                this,
                "Nome: $nome\nCPF: $cpf\nEstado: $estado\nCidade: $cidade\nLinguagens: $linguagensEscolhidas\nParadigma: $paradigmaSelecionado",
                Toast.LENGTH_LONG
            ).show()
        }

        botaoCancelar.setOnClickListener {
            campoNome.text.clear()
            campoCPF.text.clear()
            campoEstado.text.clear()
            campoCidade.text.clear()
            checkJava.isChecked = false
            checkPHP.isChecked = false
            checkCSharp.isChecked = false
            grupoParadigma.clearCheck()
        }
    }
}
