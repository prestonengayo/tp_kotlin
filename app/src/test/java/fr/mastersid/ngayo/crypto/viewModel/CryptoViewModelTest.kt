package fr.mastersid.ngayo.crypto.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import fr.mastersid.ngayo.crypto.data.CryptoUtil
import fr.mastersid.ngayo.crypto.data.EncryptionResult
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

private const val FAKE_RESULT_FIRST = "Uryyb jbeyq"
private const val FAKE_RESULT_SECOND = "!"
class CryptoUtilFake : CryptoUtil {
    override fun cesar(text: String): String {
        return if (text =="Hello world"){
            FAKE_RESULT_FIRST
        } else{
            FAKE_RESULT_SECOND
        }
    }
}
@RunWith(MockitoJUnitRunner::class )
class CryptoViewModelTest{

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var cryptoUtil: CryptoUtil

    @Test
    fun `Verification that CryptoViewModel responds correctly when the encrypt() method is called test encrypt method with Hello world`(){
        val savedStateHandle = SavedStateHandle()
        Mockito.`when`(cryptoUtil.cesar("Hello world")).thenReturn(FAKE_RESULT_FIRST)
        val cryptoViewModel = CryptoViewModel(savedStateHandle,cryptoUtil)
        cryptoViewModel.encrypt("Hello world")

        Mockito.verify(cryptoUtil, Mockito.times(1)).cesar("Hello world")

        cryptoViewModel.encryptionResult.observeForever{ value ->
            assertThat(value).isEqualTo(EncryptionResult.Encrypted(FAKE_RESULT_FIRST))
        }
    }

    @Test
    fun `Verification that CryptoViewModel responds correctly when the encrypt() method is called test encrypt method with Hello world!`(){
        val savedStateHandle = SavedStateHandle()
        Mockito.`when`(cryptoUtil.cesar("Hello world!")).thenReturn(FAKE_RESULT_SECOND)
        val cryptoViewModel = CryptoViewModel(savedStateHandle,cryptoUtil)
        cryptoViewModel.encrypt("Hello world!")

        Mockito.verify(cryptoUtil, Mockito.times(1)).cesar("Hello world!")

        cryptoViewModel.encryptionResult.observeForever{ value ->
            assertThat(value).isEqualTo(EncryptionResult.Encrypted(FAKE_RESULT_SECOND))
        }
    }

}