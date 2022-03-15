package com.another.appmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.another.appmvvm.R
import com.another.appmvvm.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var vm : MainActivityViewModel
    lateinit var ma : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider


        with(binding){

            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, RecyclerViewFragment()).commit()

            floatingActionButton.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, EditNoteFragment()).commit()
            }
        }

    }
}

