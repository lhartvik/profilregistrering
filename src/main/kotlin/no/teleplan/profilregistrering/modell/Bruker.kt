package no.teleplan.profilregistrering.modell

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

@Entity
data class Bruker (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var brukerId: Long?,

    @NotBlank(message = "Brukernavn kan ikke være blankt!")
    var brukernavn:String,
    var passord:String
)