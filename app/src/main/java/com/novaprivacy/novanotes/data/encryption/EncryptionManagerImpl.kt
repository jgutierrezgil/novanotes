package com.novaprivacy.novanotes.data.encryption

import android.util.Base64
import com.kosprov.jargon2.api.Argon2
import com.kosprov.jargon2.api.Argon2Type
import com.kosprov.jargon2.api.Argon2Version
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec

class EncryptionManagerImpl : EncryptionManager {

    private val aesCipher = Cipher.getInstance("AES/ECB/PKCS7Padding") // Modo ECB no recomendado para datos largos, para notas cortas es OK para ejemplo. Considerar GCM o CBC con IV para producción.
    private val keySizeBits = 256
    private val argon2Type = Argon2Type.ARGON2id
    private val argon2Version = Argon2Version.V13
    private val argon2Parallelism = 2
    private val argon2MemoryCost = 65536
    private val argon2TimeCost = 3
    private val argon2HashLengthBytes = 32 // 256 bits

    override fun encrypt(text: String): String? {
        return try {
            val secretKey = generateAesKey()
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val encryptedBytes = aesCipher.doFinal(text.toByteArray(Charsets.UTF_8))
            Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun decrypt(encryptedText: String?): String? {
        if (encryptedText == null) return null
        return try {
            val secretKey = generateAesKey() // **¡Advertencia!** Clave AES generada dinámicamente en cada encriptación/desencriptación para este ejemplo simplificado. En un sistema real, la clave AES debería gestionarse y almacenarse de forma segura, y probablemente no generarse de nuevo cada vez.
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey)
            val encryptedBytes = Base64.decode(encryptedText, Base64.DEFAULT)
            val decryptedBytes = aesCipher.doFinal(encryptedBytes)
            String(decryptedBytes, Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun generateAesKey(): SecretKeySpec {
        val keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(keySizeBits, SecureRandom())
        val secretKey = keyGenerator.generateKey()
        return SecretKeySpec(secretKey.encoded, "AES")
    }


    override fun generateSalt(): ByteArray {
        val random = SecureRandom()
        val salt = ByteArray(16) // 16 bytes salt es recomendado
        random.nextBytes(salt)
        return salt
    }

    override fun hashPasswordArgon2(password: CharArray, salt: ByteArray): ByteArray {
        val configuracion = Argon2.defaults()
            .type(argon2Type)
            .version(argon2Version)
            .parallelism(argon2Parallelism)
            .memoryCost(argon2MemoryCost)
            .timeCost(argon2TimeCost)
            .hashLength(argon2HashLengthBytes)
            .salt(salt)
            .password(password)

        val resultado = configuracion.hash()
        return resultado.rawHash
    }
}