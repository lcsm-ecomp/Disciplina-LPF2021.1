//Programa que roda no navegador
import kotlinx.browser.*


@JsName("botaoLimpar")
fun limpar() {
    if (window.confirm("Voce tem certeza")) {
      val elem = document.getElementById("p1")
      if (elem!=null) {
          elem.innerHTML = ""
      }
    }
}

@JsName("botaoClicado")
fun botaoClicado(nome:String) {
    println("O usuario clicou o botão $nome")
    val elem = document.getElementById("p1")
    if (elem!=null) {
        elem.innerHTML += """
            <br> <font color="$nome">Este texto foi inserido pelo programa Kotlin 
            ao pressionar o botao $nome</font>
            <button onclick="FrontEnd.botaoClicado('yellow')">Nao aperte esse botao</button>
            """
    }
}

fun main() {
    println("ola do navegador")
    for (c in 1..100)
      println("Linha impressa em kotlin numero $c")
    window.alert("Bem vidos ao meu site") 
    window.setInterval({
        val elem = document.getElementById("p1")
        if (elem!=null) {
            elem.innerHTML += "<br> Tick\n"
        }
    },1000)
}