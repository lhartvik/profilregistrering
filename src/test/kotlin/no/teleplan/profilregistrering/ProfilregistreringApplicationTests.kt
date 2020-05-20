package no.teleplan.profilregistrering

import no.teleplan.profilregistrering.modell.Profil
import no.teleplan.profilregistrering.repo.ProfilRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProfilregistreringApplicationTests(@Autowired val profilRepository: ProfilRepository) {

    @Test
    fun contextLoads() {
    }
}
