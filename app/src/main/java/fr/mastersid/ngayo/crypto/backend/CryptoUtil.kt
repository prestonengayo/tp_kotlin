package fr.mastersid.ngayo.crypto.backend

interface CryptoUtil {
    @Throws(IllegalCharException::class)
    fun cesar(text: String): String

    @Throws(IllegalCharException::class)
    fun encrypt(text: String, shift : Int): String
}