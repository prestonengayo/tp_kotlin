package fr.mastersid.ngayo.crypto.data

sealed interface EncryptionResult {

    data object Empty : EncryptionResult
    @JvmInline
    value class Encrypted ( val text : String ) : EncryptionResult
    @JvmInline
    value class Failed ( val faulty : Char ) : EncryptionResult
}