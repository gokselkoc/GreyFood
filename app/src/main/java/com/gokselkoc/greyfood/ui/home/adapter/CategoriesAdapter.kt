package com.gokselkoc.greyfood.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.greyfood.databinding.CategoriesItemViewBinding
import com.gokselkoc.greyfood.models.CategoriesResponse

class CategoriesAdapter(
    var list: ArrayList<CategoriesResponse>,
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {


    fun addToAdapter(newList: ArrayList<CategoriesResponse>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: CategoriesItemViewBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoriesResponse) {
            binding.item = item
            binding.categoriesImageView.setImageResource(item.picture)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoriesItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}