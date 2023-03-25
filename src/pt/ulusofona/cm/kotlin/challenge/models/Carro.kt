package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(identificador: String, var motor: Motor): Veiculo(identificador), Ligavel {

    override fun requerCarta() : Boolean {
        return true
    }

    override fun ligar() {
        motor.ligar()
    }

    override fun desligar() {
        motor.desligar()
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }

    override fun moverPara(x: Int, y: Int) {
        if(!estaLigado()) {
            ligar()
        }
        super.moverPara(x, y)
        desligar()
    }

    override fun toString(): String {
        return "Carro | $identificador | ${Data(dataDeAquisicao)} | $posicao"
    }
}