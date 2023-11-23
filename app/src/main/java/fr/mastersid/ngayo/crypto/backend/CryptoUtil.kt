package fr.mastersid.ngayo.crypto.backend

interface CryptoUtil {
    @Throws(IllegalCharException::class)
    fun cesar(text: String): String
}