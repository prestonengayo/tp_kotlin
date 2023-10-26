package fr.mastersid.ngayo.crypto.viewModel

import CryptoUtil
import IllegalCharException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import fr.mastersid.ngayo.crypto.data.EncryptionResult

private const val STATE_KEY_RESULT = "state_key_result"
class CryptoViewModel(state : SavedStateHandle): ViewModel(){
    private val cryptoUtil : CryptoUtil = CryptoUtil()

    private val _encryptionResult : MutableLiveData<EncryptionResult> = state.getLiveData(
        STATE_KEY_RESULT , EncryptionResult.Empty)
    val encryptionResult : LiveData<EncryptionResult> = _encryptionResult

    fun encrypt(text: String){
        try {
            this._encryptionResult.value = EncryptionResult.Encrypted(this.cryptoUtil.cesar(text))
        }catch (e:IllegalCharException){
            this._encryptionResult.value = EncryptionResult.Failed(e.message.last())
        }
    }
}