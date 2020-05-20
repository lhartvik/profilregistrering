package no.teleplan.profilregistrering.modell

import org.hibernate.bytecode.enhance.spi.interceptor.AbstractLazyLoadInterceptor
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Profil(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @NotBlank
        @Column(nullable = false)
        var navn: String,

        @OneToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.MERGE))
        @JoinColumn(name = "brukerId")
        var bruker:Bruker
)