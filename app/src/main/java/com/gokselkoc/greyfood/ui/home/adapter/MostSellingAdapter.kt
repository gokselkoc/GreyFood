package com.gokselkoc.greyfood.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.greyfood.databinding.MostSellingItemViewBinding
import com.gokselkoc.greyfood.models.MostSellingResponse

class MostSellingAdapter(
    context: Context,
    private var list : ArrayList<MostSellingResponse>
) : RecyclerView.Adapter<MostSellingAdapter.ViewHolder>()  {


    fun addToAdapter(newList: ArrayList<MostSellingResponse>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: MostSellingItemViewBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MostSellingResponse) {
            binding.item = item
            binding.mostSellingImageView.setImageResource(item.picture)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MostSellingItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}