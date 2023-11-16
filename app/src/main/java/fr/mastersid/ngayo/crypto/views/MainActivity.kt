package fr.mastersid.ngayo.crypto.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import fr.mastersid.ngayo.crypto.R
import fr.mastersid.ngayo.crypto.data.EncryptionResult
import fr.mastersid.ngayo.crypto.databinding.ActivityMainBinding
import fr.mastersid.ngayo.crypto.viewModel.CryptoViewModel
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val cryptoViewModel : CryptoViewModel by viewModels()


    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val binding = ActivityMainBinding.inflate(layoutInflater)// biding between xml and kt file
        val binding = ActivityMainBinding.inflate(layoutInflater) // biding between xml and kt file
        setContentView(binding.root)



        val encryptedText = binding.ecryptedText
        val errorTextEncrypt = binding.viewError
        val textError = binding.textError



        // send input text to viewModel if inputText input is not empty
       binding.buttonEncrypt.setOnClickListener {
           val inputText = binding.editTextInput.text
           cryptoViewModel.encrypt(inputText.toString())
        }


        // observe result value in the live data
        cryptoViewModel.encryptionResult.observe(this){ value->
           when(value){
               is EncryptionResult.Encrypted -> {
                   encryptedText.visibility = View.VISIBLE
                   errorTextEncrypt.visibility = View.GONE
                   textError.visibility = View.GONE
                   encryptedText.text = getString(R.string.encryptText,value.text)
                }
                is EncryptionResult.Failed -> {
                    errorTextEncrypt.visibility = View.VISIBLE
                    textError.visibility = View.VISIBLE
                    encryptedText.visibility = View.GONE
                    textError.text = getString(R.string.encryptError,value.faulty)
                }
                is EncryptionResult.Empty -> {
                    errorTextEncrypt.visibility = View.GONE
                    textError.visibility = View.GONE
                }
            }
        }

    }
}