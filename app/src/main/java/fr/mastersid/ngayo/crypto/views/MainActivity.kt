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
        val binding = ActivityMainBinding.inflate(layoutInflater) // biding between xml and kt file
        setContentView(binding.root)
    }
}