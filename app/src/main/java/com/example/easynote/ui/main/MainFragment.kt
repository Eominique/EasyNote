package com.example.easynote.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.easynote.data.Note
import com.example.easynote.databinding.FragmentMainBinding
import com.example.easynote.ui.adapter.NotesAdapter
import com.example.easynote.util.navigateSafe

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    val binding get() = _binding!!
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var noteT: Note
    private lateinit var notesList: MutableList<Note>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToCreateNote()
        setUpRv()

        removeItemTouch()
        editNotes()
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        TODO("Not yet implemented")
    }

    private fun editNotes() {
        TODO("Not yet implemented")
    }

    private fun removeItemTouch() {
        val itemTouchHelper = ItemTouchHelper(removeFromRecycler())
        itemTouchHelper.attachToRecyclerView(binding.noteRv)
    }

    private fun removeFromRecycler() = object : ItemTouchHelper.SimpleCallback(
        0,
        ItemTouchHelper.LEFT or
                ItemTouchHelper.RIGHT or
                ItemTouchHelper.DOWN or
                ItemTouchHelper.UP
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            //Remove swiped item from list and notify the RecyclerView
            if (notesList.isNotEmpty()) {
                val position = viewHolder.adapterPosition
                val item = notesList.removeAt(position)
            }
        }
    }

    private fun setUpRv() = binding.apply {
        noteRv.setHasFixedSize(true)
        noteRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        noteRv.adapter = notesAdapter
    }

    private fun navigateToCreateNote() {
        binding.floatingActionButton.setOnClickListener {
            navigateSafe(MainFragmentDirections.actionHomeFragmentToCreateNoteFragment(Note()))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}