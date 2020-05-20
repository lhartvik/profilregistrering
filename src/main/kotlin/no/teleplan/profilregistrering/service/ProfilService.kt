package no.teleplan.profilregistrering.service

import no.teleplan.profilregistrering.repo.ProfilRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfilService @Autowired constructor(val profilRepository: ProfilRepository) : ProfilRepository by profilRepository {
    fun profiler() = profilRepository.findAll().toList();
    fun profil(id:Long) = profilRepository.findById(id);
}