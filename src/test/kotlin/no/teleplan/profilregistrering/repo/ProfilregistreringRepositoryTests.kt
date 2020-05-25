package no.teleplan.profilregistrering.repo

import no.teleplan.profilregistrering.modell.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProfilregistreringRepositoryTests(@Autowired val userRepository: UserRepository) {

    @BeforeEach
    internal fun setUp() {
        userRepository.deleteAll()
    }

    @Test
    internal fun kanLagreProfilTilDatabaseAltKanVereBlankt() {
        val user = User()

        assertThat(user.id).isNull()
        userRepository.save(user)
        assertThat(user.id).isNotNull()

        val lastInRepo = userRepository.findAll().last()
        assertThat(lastInRepo.id).isEqualTo(user.id)
        assertThat(lastInRepo.userName).isEqualTo("")
    }
}