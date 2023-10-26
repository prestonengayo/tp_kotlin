package fr.mastersid.ngayo.crypto.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.google.common.truth.Truth.assertThat
import fr.mastersid.ngayo.crypto.data.EncryptionResult
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test

class CryptoViewModelTest{

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun `Verification that CryptoViewModel responds correctly when the encrypt() method is called test encrypt method with "Hello world"`(){
        val savedStateHandle = SavedStateHandle()
        val cryptoViewModel = CryptoViewModel(savedStateHandle)
        cryptoViewModel.encrypt("Hello world")

        cryptoViewModel.encryptionResult.observeForever{ value ->
            when (value) {
                is EncryptionResult.Encrypted -> assertThat(value.text).isEqualTo("Uryyb jbeyq")
                is EncryptionResult.Empty -> fail("expected : EncryptionResult.Encrypted \n but was : EncryptionResult.Empty")
                is EncryptionResult.Failed -> fail("expected : EncryptionResult.Encrypted \n but was : EncryptionResult.Failed")
            }
        }
    }

    @Test
    fun `Verification that CryptoViewModel responds correctly when the encrypt() method is called test encrypt method with "Hello world!"`(){
        val savedStateHandle = SavedStateHandle()
        val cryptoViewModel = CryptoViewModel(savedStateHandle)
        cryptoViewModel.encrypt("Hello world!")

        cryptoViewModel.encryptionResult.observeForever{ value ->
            when (value) {
                is EncryptionResult.Encrypted -> fail("expected : EncryptionResult.Failed \n but was : DiceResult.Encrypted")
                is EncryptionResult.Empty -> fail("expected : EncryptionResult.Failed \n but was : DiceResult.NotRolled")
                is EncryptionResult.Failed -> assertThat(value.faulty.toString()).isEqualTo("!")
            }
        }
    }

}