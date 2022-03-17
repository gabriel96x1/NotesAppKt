package com.another.appmvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.another.appmvvm.R
import com.another.appmvvm.databinding.FragmentEditNoteBinding
import com.another.appmvvm.databinding.FragmentRecyclerViewBinding
import com.another.appmvvm.ui.model.Note
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.Contexts.getApplication

@AndroidEntryPoint
class EditNoteFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentEditNoteBinding? = null
    val sharedViewModel : MainActivityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        val view = _binding!!.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = _binding

        binding!!.button.setOnClickListener {

            //val newNote = Note(binding.title.text.toString(), binding.body.text.toString())
            //vm.setNewNote(newNote)

            Navigation.findNavController(view).navigate(R.id.action_editNoteFragment_to_recyclerViewFragment)

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}