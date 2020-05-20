package no.teleplan.profilregistrering.controller

import no.teleplan.profilregistrering.modell.Bruker
import no.teleplan.profilregistrering.modell.Profil
import no.teleplan.profilregistrering.service.ProfilService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

@ExtendWith(SpringExtension::class)
internal class ProfilControllerIT {

    private lateinit var mvc: MockMvc;

    @Mock
    private lateinit var mockProfilService: ProfilService

    @InjectMocks
    private lateinit var mockProfilController: ProfilController

    @BeforeEach
    internal fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(mockProfilController).build()
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
        given(mockProfilService.profil(1337)).willReturn(Optional.of(
                Profil(id = 1, profiltekst = "", bruker = Bruker(brukerId = null, brukernavn = "", passord = ""))))

        mvc.perform(get("/profil/1337"))
                .andExpect(status().isOk);
    }
}