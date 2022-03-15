package com.another.appmvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.another.appmvvm.R
import com.another.appmvvm.databinding.FragmentEditNoteBinding
import com.another.appmvvm.databinding.FragmentRecyclerViewBinding
import com.another.appmvvm.ui.model.Note

class EditNoteFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentEditNoteBinding? = null
    lateinit var vm : MainActivityViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        val view = _binding!!.root

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}