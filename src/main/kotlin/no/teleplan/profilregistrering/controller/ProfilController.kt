package no.teleplan.profilregistrering.controller

import no.teleplan.profilregistrering.modell.Profil
import no.teleplan.profilregistrering.service.ProfilService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfilController(@Autowired private val profilService: ProfilService) {
    @GetMapping("/profiler")
    fun getAlleProfiler() = profilService.profiler()

    @GetMapping("/profil/{profilId}")
    fun getProfil(@PathVariable profilId: Long): ResponseEntity<Profil> {
        return profilService.profil(profilId)
                .map { profil -> ResponseEntity.ok(profil) }
                .orElse(ResponseEntity.notFound().build())
    }

}