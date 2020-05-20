package no.teleplan.profilregistrering.security

import no.teleplan.profilregistrering.security.service.CustomUserDetailsService
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.PasswordEncoder



@EnableWebSecurity
open class WebSecurityConfiguration(private val customUserDetailsService: CustomUserDetailsService,
									private val passwordEncoderAndMatcher: PasswordEncoder)
	: WebSecurityConfigurerAdapter() {

	override fun configure(http: HttpSecurity) {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/profiler").authenticated()
				.and()
				.httpBasic() //This line will enable Basic Authentication as well. It can be used to access REST API from Postman using Basic Authentication
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().csrf()
				.and().exceptionHandling().accessDeniedPage("/access_denied")
	}

	override fun configure(auth: AuthenticationManagerBuilder) {
		auth.userDetailsService(customUserDetailsService)
				.passwordEncoder(passwordEncoderAndMatcher)
	}
}