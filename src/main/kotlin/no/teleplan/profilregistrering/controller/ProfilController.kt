package no.teleplan.profilregistrering.controller

import no.teleplan.profilregistrering.modell.User
import no.teleplan.profilregistrering.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfilController(@Autowired private val profilRepository: UserRepository) {

    @GetMapping("/profiler")
    fun getAlleProfiler(): List<User> = profilRepository.findAll().toList()

    @GetMapping("/profil/{profilId}")
    fun getProfil(@PathVariable profilId: Long): ResponseEntity<User> =
            profilRepository.findById(profilId).map { profil ->
                ResponseEntity.ok(profil)
            }.orElse(ResponseEntity.notFound().build())

}