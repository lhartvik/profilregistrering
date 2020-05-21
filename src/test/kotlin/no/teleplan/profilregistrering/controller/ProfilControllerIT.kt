package no.teleplan.profilregistrering.controller

import no.teleplan.profilregistrering.modell.User
import no.teleplan.profilregistrering.service.ProfilService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

@ExtendWith(SpringExtension::class)
internal class ProfilControllerIT {
    private lateinit var mvc: MockMvc;
    @Mock private lateinit var mockProfilService: ProfilService
    @InjectMocks private lateinit var mockProfilController: ProfilController

    @BeforeEach
    internal fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(mockProfilController).build()
    }

    @Test
    internal fun getAlleProfiler() {
        mvc.perform(get("/profiler"))
    }

    @Test
    fun getBrukerByIdGracefullyDoesNotExist() {
        mvc.perform(get("/profiler/666"))
                .andExpect(status().isNotFound);
    }

    @Test
    fun getProfilById() {
        val user = User(userName = "Navn")
        user.id = 1337
        given(mockProfilService.bruker(1337)).willReturn(Optional.of(user))

        mvc.perform(get("/profiler/1337"))
                .andExpect(status().isOk)
                .andExpect(content().json("{'id':1337, 'userName':'Navn'}"))
    }

    @Test
    fun getBrukerByUserNameGracefullyDoesNotExist() {
        mvc.perform(get("/profil/Navn"))
                .andExpect(status().isNotFound);
    }

    @Test
    fun getProfilByUserName() {
        given(mockProfilService.bruker("Navn")).willReturn(User(userName="Navn"))

        mvc.perform(get("/profil/Navn"))
                .andExpect(status().isOk)
                .andExpect(content().encoding("ISO-8859-1") )
                .andExpect(content().json("{'userName':'Navn'}"))
    }
}