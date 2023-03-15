package com.example.easynote.ui.main

import com.example.easynote.data.Note
import com.example.easynote.util.Action

sealed class MainAction: Action {

data class GetNoteList(val noteList: List<Note>): MainAction()
data class OnSearchByTitle(val notes: List<Note>): MainAction()
data class OnRemove(val id: Int): MainAction()
}