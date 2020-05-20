package no.teleplan.profilregistrering.repo

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProfilregistreringRepositoryTests(@Autowired val brukerRepository: UserRepository) {

    @BeforeEach
    internal fun setUp() {
        brukerRepository.deleteAll()
    }

//    @Test
//    internal fun kanLagreProfilTilDatabase() {
//        val profil = Profil(id = null, navn = "Navnet", bruker = Bruker(brukernavn = "Lars", passord = "passord", brukerId = null))
//
//        assertThat(profil.id).isNull()
//        brukerRepository.save(profil)
//        assertThat(profil.id).isNotNull()
//
//        val lastInRepo = brukerRepository.findAll().last()
//        assertThat(lastInRepo.id).isEqualTo(profil.id)
//        assertThat(lastInRepo.navn).isEqualTo("Navnet")
//    }

//    @Test
//    internal fun skalIkkeAkseptereTommeNavn() {
//        val profil = Profil(id = null, navn = "",
//                bruker = Bruker(brukerId = null, brukernavn = "Guvanch", passord = "AnnetPassord"))
//        val save = brukerRepository.save(profil)
//
//        print("stop")
//    }
}