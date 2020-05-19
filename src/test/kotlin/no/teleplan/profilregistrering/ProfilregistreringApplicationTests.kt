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

    @Test
    internal fun kanLagreProfilTilDatabase() {
        val profil = Profil(id = null, navn = "Navnet")

        assertThat(profil.id).isNull()
        profilRepository.save(profil)
        assertThat(profil.id).isNotNull()

        val lastInRepo = profilRepository.findAll().last()
        assertThat(lastInRepo.id).isEqualTo(profil.id)
        assertThat(lastInRepo.navn).isEqualTo("Navnet")
    }
}
