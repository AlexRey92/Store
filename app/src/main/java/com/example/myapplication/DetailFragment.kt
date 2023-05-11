package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {
private lateinit var productPrice:TextView
private lateinit var productTitle:TextView
private lateinit var productDescription:TextView
private lateinit var productImage:ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView:View=inflater.inflate(R.layout.fragment_detail, container, false)
        productDescription=myView.findViewById(R.id.DetailDescription)
        productImage=myView.findViewById(R.id.DetailImageview)
        productPrice=myView.findViewById(R.id.DetailPrice)
        productTitle=myView.findViewById(R.id.DetailTitle)
        return myView
    }

   /*fun getDatos(it: Cloth) {
        productPrice.text=it.price.toString()

    }*/
}