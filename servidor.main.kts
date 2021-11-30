@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.springframework.boot:spring-boot-starter-web:2.5.7")
@file:DependsOn("org.springframework.boot:spring-boot-starter-test:2.5.7")

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


println("ola para todos")
println("Teste de Modificacao no github")


@SpringBootApplication
class DemoApplication {

}

runApplication<DemoApplication>(*args)
