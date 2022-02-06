package com.example.gasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun CalcularPreco(view: View){

        //recuperar valores digitados
        //val precoAlcool = findViewById<>(R.id.editPrecoAlcool)
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool,precoGasolina)
        if (validaCampos){
            calcularMelhorPreco(precoAlcool,precoGasolina)}
        else {textResultado.text = "Preencha os preços primeiro!"}

    }
    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {

        //Converte valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /*Faz cálculo ( precoAlcool / precoGasolina )
            * Se resultado >= 0.7 melhor utilizar gasolina
            * senão melhor utilizar Álcool
        * */
        val resultadoPreco = valorAlcool / valorGasolina

        //teste de validação
        if( resultadoPreco >= 0.7 ){
            textResultado.text = "Melhor utilizar Gasolina!"
        }else{
            textResultado.text = "Melhor utilizar Álcool!"
        }

    }
    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")) {
            camposValidados = false
        }
        return camposValidados
    }
}
