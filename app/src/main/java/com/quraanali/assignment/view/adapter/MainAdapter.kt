package com.quraanali.assignment.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quraanali.assignment.R
import com.quraanali.assignment.model.models.Articles
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val articles: ArrayList<Articles.Result>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(articles: Articles.Result) {
            itemView.textViewUserName.text = articles.title
            itemView.textViewUserEmail.text = articles.source
            Glide.with(itemView.imageViewAvatar.context)
                .load(articles.etaId)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(articles[position])

    fun addData(list: Articles) {
        articles.addAll(list.results)
    }

}