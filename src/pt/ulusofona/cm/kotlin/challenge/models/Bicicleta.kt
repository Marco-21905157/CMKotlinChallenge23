package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(identificador: String): Veiculo(identificador) {
    override fun toString(): String {
        return "Bicicleta | $identificador | ${Data(dataDeAquisicao)} | $posicao"
    }
}