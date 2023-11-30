package fr.mastersid.ngayo.crypto.backend


import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertThrows
import org.junit.Test
private const val CESAR_DEFAULT_SHIFT = 13
class CryptoUtilTestBackend{

    @Test
    fun `check ecrypt result of abcdefghijklmnopqrstuvwxyz`(){
        val cryptoBackend= CryptoUtilImpl()
        val encryptResult = cryptoBackend.encrypt("abcdefghijklmnopqrstuvwxyz",CESAR_DEFAULT_SHIFT)
        assertThat(encryptResult).isEqualTo("nopqrstuvwxyzabcdefghijklm")
    }

    @Test
    fun `check ecrypt result of ABCDEFGHIJKLMNOPQRSTUVWWYZ`(){
        val cryptoBackend= CryptoUtilImpl()
        val encryptResult = cryptoBackend.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ",CESAR_DEFAULT_SHIFT)
        assertThat(encryptResult).isEqualTo("NOPQRSTUVWXYZABCDEFGHIJKLM")
    }

    @Test
    fun `check ecrypt result of Space Character`(){
        val cryptoBackend = CryptoUtilImpl()
        val encryptResult = cryptoBackend.encrypt(" ",CESAR_DEFAULT_SHIFT);
        assertThat(encryptResult).isEqualTo(" ")

    }


    @Test(expected = IllegalCharException::class)
    fun `check ecrypt result of "!" generates an Exception`(){
        val cryptoBackend = CryptoUtilImpl()
        cryptoBackend.encrypt("!",CESAR_DEFAULT_SHIFT);
    }

    @Test
    fun `check encrypt result of "!" generates an Exception example 2`() {
        val cryptoBackend = CryptoUtilImpl()
        assertThrows(IllegalCharException::class.java) {
            cryptoBackend.encrypt("!",CESAR_DEFAULT_SHIFT)
        }
    }
}