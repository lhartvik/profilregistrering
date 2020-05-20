package no.teleplan.profilregistrering

import no.teleplan.profilregistrering.repo.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProfilregistreringApplicationTests(@Autowired val profilRepository: UserRepository) {

    @Test
    fun contextLoads() {
    }
}
