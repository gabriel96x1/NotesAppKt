package com.another.appmvvm.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.another.appmvvm.R
import com.another.appmvvm.databinding.FragmentRecyclerViewBinding
import com.another.appmvvm.ui.adapter.CustomRecyclerViewAdapter
import com.another.appmvvm.ui.model.Note
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.Contexts
import javax.inject.Inject

@AndroidEntryPoint
class RecyclerViewFragment : Fragment() {

    val sharedViewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentRecyclerViewBinding? = null

    lateinit var notesInfo : List<Note>


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

        val notesObserver = Observer<List<Note>> {
            // Update the UI, in this case, a TextView.
            notesInfo = it
        }
        sharedViewModel.showAllNotes().observe(viewLifecycleOwner, notesObserver)

        binding!!.floatingActionButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_recyclerViewFragment_to_editNoteFragment)
        }


        binding.recycler.adapter = CustomRecyclerViewAdapter(notesInfo)

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}