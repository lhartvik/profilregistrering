package no.teleplan.profilregistrering

import no.teleplan.profilregistrering.modell.Profil
import no.teleplan.profilregistrering.repo.ProfilRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProfilregistreringApplication

fun main(args: Array<String>) {
    runApplication<ProfilregistreringApplication>(*args)
}