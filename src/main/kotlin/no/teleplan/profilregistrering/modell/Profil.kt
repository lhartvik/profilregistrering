package no.teleplan.profilregistrering.modell

import javax.persistence.*

@Entity
data class Profil(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        var profiltekst: String?,

        @OneToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name = "brukerId")
        var bruker: Bruker?
)