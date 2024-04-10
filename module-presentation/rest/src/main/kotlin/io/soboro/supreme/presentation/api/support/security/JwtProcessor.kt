package io.soboro.supreme.presentation.api.support.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.util.*

@PropertySource("classpath:/jwt.yml")
@Component
class JwtProcessor(
    @Value("\${jwt.secret}")
    private val secret: String,
    @Value("\${jwt.expiration}")
    private val expiration: Long,
    @Value("\${jwt.prefix}")
    private val prefix: String,
) {
    private val algorithm = Algorithm.HMAC256(secret)
    private val verifier: JWTVerifier =
        JWT.require(algorithm)
            .build()

    companion object {
        const val CLAIM_KEY_USERNAME = "username"
    }

    fun generateToken(userDetails: CustomUserDetails): String {
        return JWT.create()
            .withExpiresAt(generateExpirationDate())
            .withSubject(userDetails.password)
            .withClaim(CLAIM_KEY_USERNAME, userDetails.username)
            .sign(algorithm)
    }

    fun validateToken(bearerToken: String): DecodedJWT {
        return verifier.verify(resolveToken(bearerToken))
    }

    private fun generateExpirationDate(): Date {
        return Date(System.currentTimeMillis() + expiration * 1000)
    }

    private fun resolveToken(bearerToken: String): String? {
        if (bearerToken.startsWith(prefix)) {
            return bearerToken.substring(prefix.length)
        }
        return null
    }
}