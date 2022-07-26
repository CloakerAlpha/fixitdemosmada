package com.example.fixitkuv1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fixitkuv1.databinding.DashboardRvLayoutBinding
import com.example.fixitkuv1.dataclasses.DataModelUser

class AdapterDashboardMateri(private val listUserData: List<DataModelUser>) :
RecyclerView.Adapter<AdapterDashboardMateri.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding =
            DashboardRvLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val datausers = listUserData[position]

        Glide.with(viewHolder.itemView.context)
            .load(datausers.gambar)
            .into(viewHolder.binding.rvDashboardImage)

        viewHolder.binding.rvDashboardJudulmateri.text = datausers.judulmateri
        viewHolder.binding.rvDashboardDeskripsimateri.text = datausers.deskripsimateri
        viewHolder.binding.rvDashboardLink.text = datausers.linkmateri

        viewHolder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUserData[viewHolder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listUserData.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(datas: DataModelUser)
    }

    class ViewHolder(var binding: DashboardRvLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}