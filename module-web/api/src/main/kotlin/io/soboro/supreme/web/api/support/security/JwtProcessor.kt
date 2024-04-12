package io.soboro.supreme.web.api.support.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
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

    fun generateToken(userDetails: CustomUserDetails): String {
        return JWT.create()
            .withExpiresAt(generateExpirationDate())
            .withSubject(userDetails.password)
            .withClaim(CLAIM_KEY_USERNAME, userDetails.username)
            .sign(Algorithm.HMAC256(secret))
    }

    fun validateToken(bearerToken: String): DecodedJWT {
        val verifier: JWTVerifier =
            JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(prefix)
                .build()

        return verifier.verify(resolveToken(bearerToken))
    }

    private fun generateExpirationDate(): Date {
        return Date(System.currentTimeMillis() + expiration.toLong() * 1000)
    }

    private fun resolveToken(bearerToken: String): String {
        if (!bearerToken.startsWith(prefix)) {
            return bearerToken.substring(prefix.length)
        }

        throw IllegalArgumentException("Bearer $bearerToken does not start with a prefix")
    }
}
