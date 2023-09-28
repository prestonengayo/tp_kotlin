package fr.mastersid.ngayo.crypto.viewModel

import CryptoUtil
import androidx.lifecycle.ViewModel

class CryptoViewModel: ViewModel(){
    private val cryptoUtil : CryptoUtil = CryptoUtil()
    fun encrypt(text: String){
        cryptoUtil.cesar(text)
    }


}