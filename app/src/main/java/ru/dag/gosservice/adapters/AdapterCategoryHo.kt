package ru.dag.gosservice.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.dag.gosservice.R
import ru.dag.gosservice.R.color.blue
import ru.dag.gosservice.R.color.white
import ru.dag.gosservice.databinding.ItemCategoryRecyclerBinding
import ru.dag.gosservice.databinding.ItemCetegoryHorizontalBinding
import ru.dag.gosservice.model.Category

class AdapterCategoryHo: RecyclerView.Adapter<AdapterCategoryHo.ViewHolder>() {

    var item = arrayListOf<String>()

    var selectedItemPos=0
    var lastItemSelectedPos = -1

    companion object {
        val NOT_SELECTED = -1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = ItemCetegoryHorizontalBinding.inflate(
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

    fun setData(model:ArrayList<String>){
        item.run {
            clear()
            addAll(model)
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val itemBinding: ItemCetegoryHorizontalBinding): RecyclerView.ViewHolder(itemBinding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(model: String){
            with(itemBinding){

                txtCategory.text = model

                if (selectedItemPos == NOT_SELECTED) {
                    txtCategory.setBackgroundResource(R.drawable.countur_blue)
                    //txtCategory.textColors = itemView.context.getColor(R.color.blue)
                } else {
                    if (selectedItemPos == adapterPosition) {
                        txtCategory.setBackgroundResource(R.drawable.blue_corners5)
                        txtCategory.setTextColor(white)

                    } else {
                        txtCategory.setBackgroundResource(R.drawable.countur_blue)
                        txtCategory.setTextColor(itemView.context.getColor(R.color.blue))
                    }
                }

                itemView.setOnClickListener {

                    if (selectedItemPos == adapterPosition) {
                        notifyItemChanged(adapterPosition)
                    } else {
                        lastItemSelectedPos = selectedItemPos
                        selectedItemPos = adapterPosition

                        notifyItemChanged(lastItemSelectedPos, Unit)
                        notifyItemChanged(selectedItemPos, Unit)
                    }

                }
            }

        }

    }
}