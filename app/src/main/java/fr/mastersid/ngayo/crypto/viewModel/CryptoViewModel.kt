package fr.mastersid.ngayo.crypto.viewModel

import fr.mastersid.ngayo.crypto.backend.IllegalCharException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.ngayo.crypto.backend.CryptoUtil
import fr.mastersid.ngayo.crypto.data.EncryptionResult
import javax.inject.Inject

private const val STATE_KEY_RESULT = "state_key_result"
@HiltViewModel
class CryptoViewModel @Inject constructor (
    state : SavedStateHandle, private val cryptoUtil: CryptoUtil
): ViewModel(){

    private val _encryptionResult : MutableLiveData<EncryptionResult> = state.getLiveData(
        STATE_KEY_RESULT , EncryptionResult.Empty)
    val encryptionResult : LiveData<EncryptionResult> = _encryptionResult

    fun encrypt(text: String, shift: Int){
        try {
            this._encryptionResult.value = EncryptionResult.Encrypted(this.cryptoUtil.encrypt(text,shift))
        }catch (e: IllegalCharException){
            this._encryptionResult.value = EncryptionResult.Failed(e.message.last())
        }
    }
}