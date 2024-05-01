package io.soboro.supreme.web.api.support.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import io.soboro.supreme.web.api.web.filter.AuthenticationFilter.Companion.INVALID_JWT_CODE
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.util.Date

@PropertySource("classpath:/jwt.yml")
@Component
class JwtProcessor(
    @Value("\${jwt.secret}")
    private val secret: String,
    @Value("\${jwt.expiration}")
    private val expiration: String,
    @Value("\${jwt.prefix}")
    private val prefix: String,
) {
    companion object {
        const val CLAIM_KEY_USERNAME = "username"
    }

    fun generateToken(email: String, password: String): String {
        return JWT.create()
            .withIssuer(prefix)
            .withExpiresAt(generateExpirationDate())
            .withSubject(password)
            .withClaim(CLAIM_KEY_USERNAME, email)
            .sign(Algorithm.HMAC256(secret))
    }

    fun validateToken(bearerToken: String): DecodedJWT {
        val verifier: JWTVerifier = JWT.require(Algorithm.HMAC256(secret))
            .withIssuer(prefix) // Make sure 'prefix' correctly represents the issuer.
            .build()

        println(bearerToken)

        return verifier.verify(resolveToken(bearerToken))
    }

    fun isOk(token: String): Boolean {
        val validateToken = validateToken(token)
        return validateToken.getClaim(CLAIM_KEY_USERNAME).asInt() != INVALID_JWT_CODE
    }

    private fun generateExpirationDate(): Date {
        return Date(System.currentTimeMillis() + expiration.toLong() * 100000L)
    }

    private fun resolveToken(bearerToken: String): String {
        if (bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length)
        }
        throw IllegalArgumentException("Bearer token does not start with expected prefix")
    }
}
