package no.teleplan.profilregistrering.repo

import no.teleplan.profilregistrering.modell.Bruker
import no.teleplan.profilregistrering.modell.Profil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProfilregistreringRepositoryTests(@Autowired val profilRepository: ProfilRepository) {

    @Test
    internal fun kanLagreProfilTilDatabase() {
        val profil = Profil(id = null, profiltekst = "Teksten",
                bruker = Bruker(brukernavn = "Lars", passord = "passord", brukerId = null))

        assertThat(profil.id).isNull()
        profilRepository.save(profil)
        assertThat(profil.id).isNotNull()

        val lastInRepo = profilRepository.findAll().last()
        assertThat(lastInRepo.id).isEqualTo(profil.id)
        assertThat(lastInRepo.profiltekst).isEqualTo("Teksten")
    }
}