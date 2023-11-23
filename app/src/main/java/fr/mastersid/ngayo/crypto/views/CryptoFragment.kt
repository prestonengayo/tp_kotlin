package fr.mastersid.ngayo.crypto.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import fr.mastersid.ngayo.crypto.R
import fr.mastersid.ngayo.crypto.data.EncryptionResult
import fr.mastersid.ngayo.crypto.databinding.FragmentCryptoBinding
import fr.mastersid.ngayo.crypto.viewModel.CryptoViewModel

@AndroidEntryPoint
class CryptoFragment : Fragment() {

    private lateinit var binding: FragmentCryptoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCryptoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cryptoViewModel: CryptoViewModel by viewModels()

        val args : ShiftFragmentArgs by navArgs()
        val shiftNumber = args.shiftNumber

        val encryptedText = binding.ecryptedText
        val errorTextEncrypt = binding.viewError
        val textError = binding.textError


        binding.buttonEncrypt.text = getString(R.string.encryptCrypto , args.shiftNumber )
        // send input text to viewModel if inputText input is not empty
        binding.buttonEncrypt.setOnClickListener {
            val inputText = binding.editTextInput.text
            cryptoViewModel.encrypt(inputText.toString(),shiftNumber)
        }


        // observe result value in the live data
        cryptoViewModel.encryptionResult.observe(viewLifecycleOwner){ value->
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