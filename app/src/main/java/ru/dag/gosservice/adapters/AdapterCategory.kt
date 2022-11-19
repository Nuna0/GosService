package ru.dag.gosservice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.dag.gosservice.databinding.ItemCategoryRecyclerBinding
import ru.dag.gosservice.databinding.ItemRecyclerBestPlaceBinding
import ru.dag.gosservice.model.BestPlaces
import ru.dag.gosservice.model.Category

class AdapterCategory: RecyclerView.Adapter<AdapterCategory.ViewHolder>() {

    var item = arrayListOf<Category>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemCategoryRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = item[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun setData(model:ArrayList<Category>){
        item.run {
            clear()
            addAll(model)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(private val itemBinding: ItemCategoryRecyclerBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(model:Category){
            //Glide.with(itemView.context).load()
            itemBinding.image.setImageDrawable(model.image)
            itemBinding.txt.text = model.name
        }

    }
}