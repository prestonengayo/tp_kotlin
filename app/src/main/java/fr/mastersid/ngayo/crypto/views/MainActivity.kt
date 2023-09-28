package fr.mastersid.ngayo.crypto.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import fr.mastersid.ngayo.crypto.data.EncryptionResult
import fr.mastersid.ngayo.crypto.databinding.ActivityMainBinding
import fr.mastersid.ngayo.crypto.viewModel.CryptoViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate (layoutInflater) // biding between xml and kt file
        setContentView(binding.root)

        val encryptButton = binding.buttonEncrypt
        val inputText = binding.editTextInput.text
        val encryptedText = binding.ecryptedText
        val errorTextEncrypt = binding.viewError;

        val cryptoViewModel : CryptoViewModel by viewModels()


        // send input text to viewModel if inputText input is not empty
        encryptButton.setOnClickListener {
            cryptoViewModel.encrypt(inputText.toString())
        }


        // observe result value in the live data
        cryptoViewModel.encryptionResult.observe(this){ value->
            when(value){
                is EncryptionResult.Failed -> {
                    errorTextEncrypt.visibility = View.VISIBLE
                }
                is EncryptionResult.Encrypted -> {
                    encryptedText.visibility = View.VISIBLE
                }
                else -> {
                    Toast.makeText(this,"Empty text in the input",Toast.LENGTH_LONG)
                }

            }
        }



    }
}