package fr.mastersid.ngayo.crypto.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.mastersid.ngayo.crypto.databinding.FragmentShiftBinding

@AndroidEntryPoint
class ShiftFragment : Fragment() {
    private lateinit var binding: FragmentShiftBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShiftBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "Please Enter the Encryption Shift"
        val duration = Toast.LENGTH_SHORT


        binding.buttonEncryptShift.setOnClickListener {
            try {
                val shiftNumber = binding.editTextInputShift.text.toString().toInt()
                val action =
                    ShiftFragmentDirections.actionShiftFragmentToCryptoFragment(shiftNumber)
                findNavController().navigate(action)
            } catch (e: NumberFormatException) {
                val toast = Toast.makeText(getActivity(), text, duration)
                toast.show()
            }
        }
    }
}