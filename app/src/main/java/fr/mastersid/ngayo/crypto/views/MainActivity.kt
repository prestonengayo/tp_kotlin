package fr.mastersid.ngayo.crypto.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import fr.mastersid.ngayo.crypto.R
import fr.mastersid.ngayo.crypto.databinding.ActivityMainBinding
import fr.mastersid.ngayo.crypto.viewModel.CryptoViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate (layoutInflater) // biding between xml and kt file
        setContentView(R.layout.activity_main)

        val encryptButton = binding.buttonEncrypt
        val inputText = binding.editTextInput.text
        val ecryptedText = binding.ecryptedText
        val errorTextEncrypt = binding.viewError;

        val cryptoViewModel : CryptoViewModel by viewModels()

    }
}