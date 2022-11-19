package ru.dag.gosservice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dag.gosservice.adapters.AdapterCategory
import ru.dag.gosservice.adapters.AdapterNews
import ru.dag.gosservice.databinding.FragmentNewsBinding
import ru.dag.gosservice.model.News

class NewsFragment : Fragment() {

    private  var _binding: FragmentNewsBinding?=null
    private  val binding get() = _binding!!

    private  val newsAdapter by lazy { AdapterNews() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputRecycler()
    }

    fun inputRecycler(){

        with(binding){
            val listNews: ArrayList<News> = ArrayList()
            listNews.add(News(context?.getDrawable(R.drawable.image_1), "179 территорий изменят облик Дагестана благодаря нацпроекту", "6 октября"))
            listNews.add(News(context?.getDrawable(R.drawable.image_2), "Экстренное отключение газа на 4 дня в Советском районе", "1 ноября"))
            listNews.add(News(context?.getDrawable(R.drawable.image_3), "Более 250 территорий благоустроят в Дагестане в 2022 году", "5 ноября"))

            newsAdapter.setData(listNews)
            newsRecycler.adapter = newsAdapter
        }
    }

}