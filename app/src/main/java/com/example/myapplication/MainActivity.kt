package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var listFragment: ListFragment
    private lateinit var detailFragment:DetailFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun switchFrag() {
        supportFragmentManager.beginTransaction().replace(R.id.FragmentList, DetailFragment())
            .commit()
    }
    
}