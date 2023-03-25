package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.util.*
import kotlin.collections.ArrayList

class Pessoa(var nome: String, var dataDeNascimento: Date) {
    var veiculos: ArrayList<Veiculo> = ArrayList()
    var carta: Carta? = null
    var posicao: Posicao = Posicao(0, 0)

    fun comprarVeiculo(veiculo: Veiculo) {
        try {
            pesquisarVeiculo(veiculo.identificador)
        }
        catch (e: VeiculoNaoEncontradoException){
            veiculo.dataDeAquisicao = Date()
            veiculos.add(veiculo)
        }
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        return veiculos.find { veiculo: Veiculo -> veiculo.identificador == identificador }
            ?: throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        try {
            val veiculo = pesquisarVeiculo(identificador)
            comprador.comprarVeiculo(veiculo)
            veiculos.remove(veiculo)
        }
        catch (_: VeiculoNaoEncontradoException){}
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        try {
            val veiculo: Veiculo = pesquisarVeiculo(identificador)
            if (veiculo.requerCarta() && !temCarta()) {
                throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
            }
            veiculo.moverPara(x, y)
        }
        catch (_: VeiculoNaoEncontradoException){}
    }

    fun temCarta(): Boolean {
        return carta != null
    }

    fun tirarCarta() {

        if (Data(dataDeNascimento).anosAteHoje() < 18) {
            throw MenorDeIdadeException()
        }
        else if (!temCarta()) {
            carta = Carta()
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${Data(dataDeNascimento)} | $posicao"
    }
}