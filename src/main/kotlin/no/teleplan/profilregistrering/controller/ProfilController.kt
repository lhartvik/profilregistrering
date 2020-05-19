package no.teleplan.profilregistrering.controller

import no.teleplan.profilregistrering.modell.Profil
import no.teleplan.profilregistrering.repo.ProfilRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfilController(@Autowired private val profilRepository: ProfilRepository) {

    @GetMapping("/profiler")
    fun getAlleProfiler(): List<Profil> = profilRepository.findAll().toList()

    @GetMapping("/profil/{profilId}")
    fun getProfil(@PathVariable profilId: Long): ResponseEntity<Profil> =
            profilRepository.findById(profilId).map { profil ->
                ResponseEntity.ok(profil)
            }.orElse(ResponseEntity.notFound().build())

}