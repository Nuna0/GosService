package ru.dag.gosservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dag.gosservice.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    private  var _binding: FragmentHelpBinding?=null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root    }


}