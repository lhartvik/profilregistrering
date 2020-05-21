package no.teleplan.profilregistrering.service

import no.teleplan.profilregistrering.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfilService @Autowired constructor(val userRepository: UserRepository){
    fun brukere() = userRepository.findAll().toList()
    fun bruker(id:Long) = userRepository.findById(id)
    fun bruker(userName: String) = userRepository.findOneByUserName(userName)
}