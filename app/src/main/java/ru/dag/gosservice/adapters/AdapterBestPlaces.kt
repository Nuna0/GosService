package ru.dag.gosservice.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.dag.gosservice.databinding.ItemRecyclerBestPlaceBinding
import ru.dag.gosservice.model.BestPlaces

class AdapterBestPlaces: RecyclerView.Adapter<AdapterBestPlaces.ViewHolder>() {

    var item = arrayListOf<BestPlaces>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemRecyclerBestPlaceBinding.inflate(
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

    fun setData(model:ArrayList<BestPlaces>){
        item.run {
            clear()
            addAll(model)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(private val itemBinding: ItemRecyclerBestPlaceBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(model: BestPlaces){
            with(itemBinding){
               // Glide.with(itemView.context).load(model.image ).into(image)
                image.setImageDrawable(model.image)
                txt.text = model.title
                txtAddress.text = model.address
                txtCategory.text = model.category
                countLike.text = model.likes.toString()
            }

        }
    }
}