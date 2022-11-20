package ru.dag.gosservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.dag.gosservice.adapters.AdapterBestPlaces
import ru.dag.gosservice.adapters.AdapterCategory
import ru.dag.gosservice.databinding.FragmentMainBinding
import ru.dag.gosservice.model.BestPlaces
import ru.dag.gosservice.model.Category


class MainFragment : Fragment() {

    private  var _binding: FragmentMainBinding?=null
    private  val binding get() = _binding!!

    private  val bestPlaceAdapter by lazy { AdapterBestPlaces() }
    private  val categoryAdapter by lazy { AdapterCategory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputRecycler()

    }

    fun inputRecycler(){
        val list: ArrayList<BestPlaces> = ArrayList()
        context?.getDrawable(R.drawable.rectangle_11)
            ?.let { BestPlaces(it, "Ремонт дороги и заклвдка асфальта", "ул. Шамиля 24", "Дорога", 250) }
            ?.let { list.add(it) }
        list.add(BestPlaces(context?.getDrawable(R.drawable.rectangle_11), "Уборка мусора и закупка новых баков", "ул. Агасиева 32", "Мой дом",234) )
        list.add(BestPlaces(context?.getDrawable(R.drawable.rectangle_11), "Уборка мусора и закупка новых баков", "ул. Агасиева 32", "Мой дом", 200) )
        list.add(BestPlaces(context?.getDrawable(R.drawable.rectangle_11), "Уборка мусора и закупка новых баков", "ул. Агасиева 32", "Мой дом", 150) )
        list.add(BestPlaces(context?.getDrawable(R.drawable.rectangle_11), "Уборка мусора и закупка новых баков", "ул. Агасиева 32", "Мой дом", 130) )

        bestPlaceAdapter.setData(list)
        binding.recyclerBestPlace.adapter = bestPlaceAdapter

        val listCategory: ArrayList<Category> = ArrayList()
        listCategory.add(Category(context?.getDrawable(R.drawable.road),"Дорога",1))
        listCategory.add(Category(context?.getDrawable(R.drawable.home),"Дом",2))
        listCategory.add(Category(context?.getDrawable(R.drawable.park),"Парк",3))
        listCategory.add(Category(context?.getDrawable(R.drawable.my_yard),"Мой двор",4))
        listCategory.add(Category(context?.getDrawable(R.drawable.my_yard),"Мой двор",4))
        listCategory.add(Category(context?.getDrawable(R.drawable.my_yard),"Мой двор",4))
        listCategory.add(Category(context?.getDrawable(R.drawable.my_yard),"Мой двор",4))
        listCategory.add(Category(context?.getDrawable(R.drawable.my_yard),"Мой двор",4))

        categoryAdapter.setData(listCategory)
        binding.categoryRecycler.adapter = categoryAdapter

        binding.icAdd.setOnClickListener {
            goToClaim()
        }

        binding.txtAddClaim.setOnClickListener {
            goToClaim()
        }

    }

    fun goToClaim(){
        findNavController().navigate(R.id.action_mainFragment_to_addClaimFragment)
    }

}