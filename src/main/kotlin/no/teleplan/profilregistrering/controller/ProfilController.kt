package no.teleplan.profilregistrering.controller

import no.teleplan.profilregistrering.modell.User
import no.teleplan.profilregistrering.service.ProfilService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfilController(@Autowired private val profilService: ProfilService) {

    @GetMapping("/profiler")
    fun getAlleProfiler(): List<User> = profilService.brukere()

    @GetMapping("/profilId/{brukerId}")
    fun getProfil(@PathVariable brukerId: Long): ResponseEntity<User> =
            profilService.bruker(brukerId)
                    .map { profil -> ResponseEntity.ok(profil) }
                    .orElse(ResponseEntity.notFound().build())

    @GetMapping("/profilBrukernavn/{brukerNavn}")
    fun getProfilByUserName(@PathVariable brukerNavn: String): ResponseEntity<User> {
        val bruker = profilService.bruker(brukerNavn)
        return if (bruker != null) ResponseEntity.ok(bruker)
                else ResponseEntity.notFound().build()
    }

}