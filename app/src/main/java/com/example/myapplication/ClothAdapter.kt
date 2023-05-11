package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ClothAdapter:ListAdapter<Cloth,ClothAdapter.ViewHolder>(DiffCallBack) {
    lateinit var onItemClickListener: (Cloth)-> Unit

    inner class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        val productID:TextView= view.findViewById(R.id.itemId1)
        val productImage:ImageView=view.findViewById(R.id.itemProduct1)
        val productRate:ImageView=view.findViewById(R.id.itemStars1)

        fun onBind(cloth:Cloth){
            val photo= cloth.image
            val rate= cloth.stars
            productID.text=cloth.id.toString()
            val price=cloth.price
            Picasso.get().load(photo).into(productImage)
        when{
            rate<1 -> productRate.setImageResource(R.drawable.ceroestrellas)
            rate < 2 -> productRate.setImageResource(R.drawable.unaestrella)
            rate < 3 ->productRate.setImageResource(R.drawable.dosestrellas)
            rate < 4 -> productRate.setImageResource(R.drawable.tresestrellas)
            rate >3 ->productRate.setImageResource(R.drawable.cuatroestrellas)
            rate.equals(5) -> productRate.setImageResource(R.drawable.cincoestrellas)
        }
        view.setOnClickListener { onItemClickListener(cloth) }

        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myView:View=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder(myView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binder=getItem(position)
        holder.onBind(binder)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Cloth>() {
        override fun areItemsTheSame(oldItem: Cloth, newItem: Cloth): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cloth, newItem: Cloth): Boolean {
            return oldItem == newItem
        }
    }


}