package ru.dag.gosservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.dag.gosservice.adapters.AdapterBestPlaces
import ru.dag.gosservice.adapters.AdapterCategoryHo
import ru.dag.gosservice.databinding.FragmentAddClaimBinding
import ru.dag.gosservice.databinding.FragmentNewsBinding

class AddClaimFragment : Fragment() {

    private  var _binding: FragmentAddClaimBinding?=null
    private  val binding get() = _binding!!

    private  val categoryAdapter by lazy { AdapterCategoryHo() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddClaimBinding.inflate(inflater, container, false)
        return binding.root     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        inputRecycler()
    }

    fun inputRecycler(){
        val list: ArrayList<String> = ArrayList()
        list.add("Дорога")
        list.add("Мой двор")
        list.add("Парк")
        list.add("Дом")

        categoryAdapter.setData(list)
        binding.recyclerCategory.adapter = categoryAdapter
    }

}