package com.novaprivacy.novanotes.data.encryption

interface EncryptionManager {
    fun encrypt(text: String): String?
    fun decrypt(encryptedText: String?): String?
    fun generateSalt(): ByteArray
    fun hashPasswordArgon2(password: CharArray, salt: ByteArray): ByteArray
}