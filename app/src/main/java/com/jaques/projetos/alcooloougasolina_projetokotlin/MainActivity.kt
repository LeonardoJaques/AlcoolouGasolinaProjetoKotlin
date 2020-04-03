package com.jaques.projetos.alcooloougasolina_projetokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var editPrecoAlcool: TextInputEditText? = null
    private var editPrecoGasolina: TextInputEditText? = null
    private var textResultado: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPrecoAlcool = idPrecoAlcool
        editPrecoGasolina = idPrecoGasolina
        textResultado = idResultado
    }

    fun calcular(v: View) {
        //Recuperar valores

        val precoAlcool = editPrecoAlcool?.getText().toString()
        val precoGasolina = editPrecoGasolina?.getText().toString()

        //Validar os campos digitados
        val camposValidados = validarCampos(precoAlcool, precoGasolina)
        if (camposValidados) {
            //Convertendo string para números
            val valorDoAlcool: Double = precoAlcool.toDouble()
            val valorDoGasolina: Double = precoGasolina.toDouble()

            val resultado = valorDoAlcool / valorDoGasolina
            if (resultado >= 0.7) {
                textResultado?.text = "é melhor comprar a gasolina"
            } else textResultado?.text = "é melhor compara o alcool"

        } else textResultado?.text = "Preencha os preços primeiro!"
    }

    fun validarCampos(pAlcool: String, pGasolina: String): Boolean {
        val camposValidados = true
        if (pAlcool == null || pAlcool == "") {
            return false
        } else if (pGasolina == null || pGasolina == "") {
            return false
        }
        return camposValidados
    }
}
