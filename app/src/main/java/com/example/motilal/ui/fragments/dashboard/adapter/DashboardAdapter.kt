package com.example.motilal.ui.fragments.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.motilal.databinding.DashboardItemBinding
import com.example.motilal.model.Result

class DashboardAdapter(private val context: Context) :
    RecyclerView.Adapter<DashboardAdapter.dashboardViewHolder>() {


    var adapterCallback: DbAdapterCallback? = null

    private val differCallback = object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem.author == newItem.author
        }

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dashboardViewHolder {


        return dashboardViewHolder(
            DashboardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: dashboardViewHolder, position: Int) {
        val dashboardData = differ.currentList[position]
        holder.bind(dashboardData,holder.itemView)


    }


    inner class dashboardViewHolder(val itemBinding: DashboardItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(dashboardData: Result?, itemView: View) {

            dashboardData?.let {
                itemBinding.tvAuther.text = "Author : ${it.author}"
                itemBinding.tvName.text = "Name : ${it.name}"
                 Glide.with(context).load(it.avatar).into(itemBinding.ivImage)

            }

            itemView.setOnClickListener {
                adapterCallback?.onTab(dashboardData)
            }
        }

    }

    interface DbAdapterCallback {

        fun onTab(dashboardData: Result?)

    }

}