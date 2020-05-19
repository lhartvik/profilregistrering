package no.teleplan.profilregistrering.controller

import no.teleplan.profilregistrering.modell.Bruker
import no.teleplan.profilregistrering.modell.Profil
import no.teleplan.profilregistrering.repo.ProfilRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

@ExtendWith(SpringExtension::class)
internal class ProfilControllerTest {

    private lateinit var mvc: MockMvc;

    @Mock
    private lateinit var profilRepository: ProfilRepository

    @InjectMocks
    private lateinit var profilController: ProfilController

    @BeforeEach
    internal fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(profilController).build()
    }

    @Test
    fun getAlleProfiler() {
        mvc.perform(get("/profiler"))
    }

    @Test
    fun getProfilFinnesIkke() {
        mvc.perform(get("/profiler/666"))
                .andExpect(status().isNotFound);
    }

    @Test
    fun getProfilFinnes() {
        given(profilRepository.findById(ArgumentMatchers.any())).willReturn(Optional.of(
                Profil(id = 1, profiltekst = "",
                        bruker = Bruker(brukerId = null, brukernavn = "", passord = ""))))
        mvc.perform(get("/profiler/666"))
                .andExpect(status().isNotFound);

        print("buhu")

    }

}