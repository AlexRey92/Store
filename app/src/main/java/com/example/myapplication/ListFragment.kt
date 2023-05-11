package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ClothAdapter
    private var listOfProducts= mutableListOf<Cloth>()
    private lateinit var detailFragment: DetailFragment
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView:View= inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView=myView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager=GridLayoutManager(this.context,2)
        adapter=ClothAdapter()
        recyclerView.adapter=adapter
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getListofProducts()
    }

    private fun getListofProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = service.getAllProducts()
            val response= call.body()

            activity?.runOnUiThread {
                if (call.isSuccessful){
                    listOfProducts=response?.map { ProductsResponse->ProductsResponse.MapToProduct() }
                            as MutableList<Cloth>
                    adapter.submitList(listOfProducts)
                    adapter.onItemClickListener={
                        mainActivity=MainActivity()
                    mainActivity.switchFrag()



                    }


                }
            }
        }

    }


}
