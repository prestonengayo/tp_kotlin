package fr.mastersid.ngayo.crypto.backend


import CryptoUtilImpl
import IllegalCharException
import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test

class CryptoUtilTestBackend{

    @Test
    fun `check ecrypt result of abcdefghijklmnopqrstuvwxyz`(){
        val cryptoBackend= CryptoUtilImpl()
        val encryptResult = cryptoBackend.cesar("abcdefghijklmnopqrstuvwxyz")
        assertThat(encryptResult).isEqualTo("nopqrstuvwxyzabcdefghijklm")
    }

    @Test
    fun `check ecrypt result of ABCDEFGHIJKLMNOPQRSTUVWWYZ`(){
        val cryptoBackend= CryptoUtilImpl()
        val encryptResult = cryptoBackend.cesar("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
        assertThat(encryptResult).isEqualTo("NOPQRSTUVWXYZABCDEFGHIJKLM")
    }

    @Test
    fun `check ecrypt result of Space Character`(){
        val cryptoBackend = CryptoUtilImpl()
        val encryptResult = cryptoBackend.cesar(" ");
        assertThat(encryptResult).isEqualTo(" ")

    }


    @Test(expected = IllegalCharException::class)
    fun `check ecrypt result of "!" generates an Exception`(){
        val cryptoBackend = CryptoUtilImpl()
        cryptoBackend.cesar("!");
    }

    @Test
    fun `check encrypt result of "!" generates an Exception example 2`() {
        val cryptoBackend = CryptoUtilImpl()
        assertThrows(IllegalCharException::class.java) {
            cryptoBackend.cesar("!")
        }
    }
}