package no.teleplan.profilregistrering.modell

import java.util.*
import javax.persistence.*


@Entity
 open class User(@JvmField var firstName: String = "",
				 @JvmField var lastName: String = "",
				 @JvmField var userName: String = "",
				 @JvmField var email: String = "",
				 @JvmField var passWord: String = "") {

	@Id @GeneratedValue
	@JvmField
	var id: Long? =null

	@JvmField var version: Int = 0

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	@JvmField
	var accountNonExpired: Boolean = true

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	@JvmField
	var accountNonLocked: Boolean = true

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	@JvmField
	var credentialsNonExpired: Boolean = true

	@Column( nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	@JvmField
	var enabled: Boolean = true

	@OneToMany(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
	@JvmField
	var roles: Set<Role> = HashSet()

	 constructor(user: User) : this(user.firstName, user.lastName, user.userName, user.email, user.passWord) {
		id = user.id
		version = user.version
		firstName = user.firstName
		lastName = user.lastName
		userName = user.userName
		email = user.email
		passWord = user.passWord
		accountNonExpired = user.accountNonExpired
		accountNonLocked = user.accountNonLocked
		credentialsNonExpired = user.credentialsNonExpired
		enabled = user.enabled
		roles = user.roles
	}
}