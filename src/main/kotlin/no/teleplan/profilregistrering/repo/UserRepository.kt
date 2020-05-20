package no.teleplan.profilregistrering.repo

import no.teleplan.profilregistrering.modell.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User, Long> {

	fun findOneByUserName(userName: String): User?

}