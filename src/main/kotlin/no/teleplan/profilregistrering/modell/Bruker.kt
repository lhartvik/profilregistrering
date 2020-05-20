package no.teleplan.profilregistrering.modell

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Bruker (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var brukerId: Long?,

    var brukernavn:String,

    var passord:String
)