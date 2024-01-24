enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun listarInscritos() {
        if (inscritos.isEmpty()) {
            println("Nenhum usuário matriculado nesta formação.")
        } else {
            println("Usuários matriculados na formação $nome:")
            inscritos.forEach { println("- ${it.nome}") }
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)
    val formacao = Formacao("Engenharia da Computação", listOf(conteudo1, conteudo2))

    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.listarInscritos()
}

