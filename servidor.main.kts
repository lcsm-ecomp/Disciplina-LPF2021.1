@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.springframework.boot:spring-boot-starter-web:2.6.0")
@file:DependsOn("org.springframework.boot:spring-boot-starter-tomcat:2.6.0")

package MeuServidor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

println("ola para todos")
println("Teste de Modificacao no github")


@SpringBootApplication
//@RestController
open class DemoApplication {

}

val arg = arrayOf(
    "--server.port=3003",
)

runApplication<DemoApplication>(*arg)
