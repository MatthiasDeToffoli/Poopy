package fr.matthiasdetoffoli.poopy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import fr.matthiasdetoffoli.poopy.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private var _addTimeMenuIsOpen: Boolean  = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)


        binding.addNewTimeOption.setOnClickListener {
            Toast.makeText(requireContext(), "Option A clicked", Toast.LENGTH_SHORT).show()
        }

        binding.AddMissingTimeOption.setOnClickListener {
            Toast.makeText(requireContext(), "Option B clicked", Toast.LENGTH_SHORT).show()
        }

        binding.fab.setOnClickListener { view ->
            _addTimeMenuIsOpen = !_addTimeMenuIsOpen;


            val lVisibility = if(_addTimeMenuIsOpen) View.VISIBLE else View.GONE

            binding.addTimeContainer.visibility = lVisibility

            binding.addTimeContainer.post()
            {
                if(_addTimeMenuIsOpen)
                {
                    if(binding.addNewTimeOption.width < binding.AddMissingTimeOption.width)
                    {
                        binding.addNewTimeOption.width = binding.AddMissingTimeOption.width
                        binding.addNewTimeOption.requestLayout()
                    }
                    else(binding.addNewTimeOption.width > binding.AddMissingTimeOption.width)
                    {
                        binding.AddMissingTimeOption.width = binding.addNewTimeOption.width
                    }
                }
            }

        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}