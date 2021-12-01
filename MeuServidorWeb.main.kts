@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.springframework.boot:spring-boot-starter-web:2.6.0")

package MeuServidorWeb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import java.io.*
import kotlin.io.*


@SpringBootApplication
@RestController
open class MinhaAplicacao {

   fun lerVezes():Int {
       val f = File("vezes.txt")

       if (!f.exists())
          return 0
       val str = f.readText()
       return Integer.parseInt(str)
   }
   var vezes = lerVezes()

   @GetMapping("/BackEnd.html")
   fun BackEnd(nome:String?) : String {
       vezes++
       File("vezes.txt").writeText(vezes.toString())
       if (nome!=null) File("acessos.txt").appendText(" " + nome)
       println("Executando a funcao BackEnd. Essa funcao foi solicitada por $nome")
       return """
       <meta charset="utf-8">
       <html>
       <body>
       Ola ${nome}, <p>
       Esse código foi produzido dinamicamente pelo servidor<p>
       Esta página foi gerada ${vezes} vezes.<p>
       Essa página foi acessada por ${File("acessos.txt").readText()}
       </body>
       </html>
       """

   }

}

runApplication<MinhaAplicacao>("--server.port=4000")


