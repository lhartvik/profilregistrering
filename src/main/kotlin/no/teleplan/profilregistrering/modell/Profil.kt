package no.teleplan.profilregistrering.modell

import javax.persistence.*

@Entity
data class Profil(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @Column(nullable = false)
        val navn: String
)