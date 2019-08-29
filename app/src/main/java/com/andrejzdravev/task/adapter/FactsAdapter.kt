package com.andrejzdravev.task.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrejzdravev.task.DetailsActivity
import com.andrejzdravev.task.model.All
import com.andrejzdravev.task.R
import kotlinx.android.synthetic.main.facts_item.view.*


class FactsAdapter(private val arrList: List<All>) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount() = arrList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRow = layoutInflater.inflate(R.layout.facts_item, parent, false)

        return CustomViewHolder(cellRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.apply {
            factText.text = arrList[position].text
        }

        holder.all = arrList[position]


    }
}

class CustomViewHolder(view: View, var all: All? = null) : RecyclerView.ViewHolder(view)  {

    companion object {
        val FACTS_DATA = "FACTS_DATA"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, DetailsActivity::class.java)

            intent.putExtra(FACTS_DATA, all)

            view.context.startActivity(intent)
        }
    }
}



