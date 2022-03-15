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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]

        with(binding){
            floatingActionButton.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, EditNoteFragment()).commit()
            }
        }

    }
}

