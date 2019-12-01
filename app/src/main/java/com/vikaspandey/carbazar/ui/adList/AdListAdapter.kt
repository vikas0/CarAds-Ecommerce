package com.vikaspandey.carbazar.ui.adList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vikaspandey.carbazar.databinding.AdItemBinding
import com.vikaspandey.carbazar.db.Car

class AdListAdapter(
    var context: Context,
    private val clickListener: ItemClickListner
) :
    ListAdapter<Car, ItemViewHolder>(CarsDiffCallBack()) {

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val current = getItem(position)
            current?.let { holder.bind(it, clickListener) }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  ItemViewHolder.from(parent)

}

class CarsDiffCallBack : DiffUtil.ItemCallback<Car>() {
    override fun areItemsTheSame(oldItem: Car, newItem: Car)= oldItem.id==newItem.id

    override fun areContentsTheSame(oldItem: Car, newItem: Car)= oldItem == newItem

}

class ItemViewHolder private constructor(private val binding: AdItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        current: Car,
        clickListener: ItemClickListner
    ) {
        binding.car = current
        binding.clickListener = clickListener
        binding.executePendingBindings()
 }

    companion object {
        fun from(parent: ViewGroup): ItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = AdItemBinding.inflate(layoutInflater, parent, false)
            return ItemViewHolder(binding)
        }
    }
}


class ItemClickListner(var clickListner: (adItemId: Int) -> Unit) {
    fun onClick(item: Car) = clickListner(item.id)

}
