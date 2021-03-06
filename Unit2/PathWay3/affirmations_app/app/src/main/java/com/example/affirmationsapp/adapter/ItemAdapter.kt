package com.example.affirmationsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmationsapp.R
import com.example.affirmationsapp.model.Affirmation

class ItemAdapter(private val dataset: List<Affirmation>) : // Event if the code lab suggest to pass context, I won't because of risk of memory leaks
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflating the view
        val adapterLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item, parent, false
        )
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        with(holder) {
            itemView.context.let { context ->
                textView.text = context.getString(item.stringResourceId)
                imageView.setImageResource(item.imageResourceId)
            }
        }
    }

    override fun getItemCount() = dataset.size

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }
}

