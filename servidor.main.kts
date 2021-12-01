@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.springframework.boot:spring-boot-starter-web:2.6.0")

package MeuServidor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import org.springframework.stereotype.Controller



data class Mensagem(val nome:String, val msg:String)

@SpringBootApplication
@RestController
open class DemoApplication { 
    val mensagens : MutableList<Mensagem> = mutableListOf()

    @GetMapping("/board/diga/{nome}/{msg}")
    fun dizer(@PathVariable nome:String, @PathVariable msg:String) : String {
        mensagens.add(Mensagem(nome,msg))
        return "Mensagem recebida"
    }
    @GetMapping("/board/listar")
    fun lista() : String {
       return """
       <html>
       <title>Lista de Mensagens</title>
       <body>
       Mensagens:<p>
       <ol>
       ${mensagens.map({ msg -> "<li> ${msg.nome} disse ${msg.msg}" } ).joinToString("\n") }
       </ol></body>
       </html>
       """

    }


    var vezes = 0
    @GetMapping("/BackEnd.html")
    fun Hello() : String {
        return """
        <meta charset="utf-8">
        <html>
        <title> Pagina Dinâmica</title>
        <body>
        Esta pagina foi gerada por um programa 
        em <b>kotlin</b>
        <p>
        Esta página foi acessada ${++vezes} vezes.
        </body>
        </html>
        """
    }
}

runApplication<DemoApplication>("--server.port=4000")


