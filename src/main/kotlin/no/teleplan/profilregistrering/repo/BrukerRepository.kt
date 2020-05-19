package no.teleplan.profilregistrering.repo

import no.teleplan.profilregistrering.modell.Profil
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BrukerRepository : CrudRepository<Profil, Long> {
}