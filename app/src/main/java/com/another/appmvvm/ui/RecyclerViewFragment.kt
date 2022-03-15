package com.another.appmvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.another.appmvvm.databinding.FragmentRecyclerViewBinding
import com.another.appmvvm.ui.adapter.CustomRecyclerViewAdapter
import com.another.appmvvm.ui.model.Note

class RecyclerViewFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentRecyclerViewBinding? = null
    lateinit var vm : MainActivityViewModel
    lateinit var notesInfo : List<Note>
    lateinit var rv : RecyclerView


    // This property is only valid between onCreateView and
    // onDestroyView.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        val binding = _binding

        vm = ViewModelProvider(this)[MainActivityViewModel::class.java]

        vm.getAllNotes()

        val notesObserver = Observer<List<Note>> {
            // Update the UI, in this case, a TextView.
            notesInfo = it
        }

        vm.showAllNotes().observe(viewLifecycleOwner, notesObserver)

        binding!!.recycler.adapter = CustomRecyclerViewAdapter(notesInfo)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}