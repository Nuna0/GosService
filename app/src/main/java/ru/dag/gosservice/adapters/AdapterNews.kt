package ru.dag.gosservice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.dag.gosservice.databinding.ItemNewsRecyclerBinding
import ru.dag.gosservice.databinding.ItemRecyclerBestPlaceBinding
import ru.dag.gosservice.model.BestPlaces
import ru.dag.gosservice.model.News

class AdapterNews: RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    var item = arrayListOf<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemNewsRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemView)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = item[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setData(model:ArrayList<News>){
        item.run {
            clear()
            addAll(model)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(private val itemBinding: ItemNewsRecyclerBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(model: News){
            with(itemBinding){
                // Glide.with(itemView.context).load(model.image ).into(image)
                image.setImageDrawable(model.image)
                txtNews.text = model.title
                txtDate.text = model.date
            }

        }
    }
}