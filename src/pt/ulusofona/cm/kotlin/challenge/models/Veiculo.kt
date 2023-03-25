package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

open class Veiculo(var identificador: String): Movimentavel {
    lateinit var posicao: Posicao
    lateinit var dataDeAquisicao: Date

    open fun requerCarta() : Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }
}