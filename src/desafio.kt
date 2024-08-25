package src

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome: String, var email: String) {
    override fun toString(): String = "Usuario(nome: $nome, email: $email)"
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
    override fun toString(): String  = "Conteudo(nome: $nome, duracao: $duracao)"
}

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    override fun toString(): String {
        return "Formacao(nome: $nome, nivel: $nivel, conteudos: $conteudos, inscritos: $inscritos}"
    }
}

fun main() {
    val usuario1 = Usuario("Usaurio1", "usuario1@email.com")
    val usuario2 = Usuario("Usaurio2", "usuario2@email.com")
    val conteudo1 = ConteudoEducacional("Loops de repetição em Kotlin", 42)
    val conteudo2 = ConteudoEducacional("POO com Kotlin", 55)
    val conteudosFormacaoKotlin: List<ConteudoEducacional> = listOf(conteudo1, conteudo2);
    val formacao = Formacao("Kotlin Básico", Nivel.BASICO, conteudosFormacaoKotlin)
    formacao.matricular(usuario1)
    println(formacao)
    formacao.matricular(usuario2)
    println(formacao)
}
