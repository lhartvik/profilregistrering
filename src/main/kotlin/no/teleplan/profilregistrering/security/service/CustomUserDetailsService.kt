package no.teleplan.profilregistrering.security.service

import no.teleplan.profilregistrering.repo.UserRepository
import no.teleplan.profilregistrering.security.CustomUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
open class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {

	override fun loadUserByUsername(username: String): UserDetails {
		return CustomUserDetails(userRepository.findOneByUserName(username)!!)
	}

}