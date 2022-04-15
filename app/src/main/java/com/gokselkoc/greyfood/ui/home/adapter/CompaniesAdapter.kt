package com.gokselkoc.greyfood.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.greyfood.databinding.CompanyLogoItemViewBinding
import com.gokselkoc.greyfood.models.CompanyResponse
import kotlinx.coroutines.test.withTestContext

class CompaniesAdapter(
    private var list : ArrayList<CompanyResponse>
) : RecyclerView.Adapter<CompaniesAdapter.ViewHolder>()  {


    fun addToAdapter(newList: ArrayList<CompanyResponse>) {

        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding: CompanyLogoItemViewBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CompanyResponse) {
            binding.item = item
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CompanyLogoItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}