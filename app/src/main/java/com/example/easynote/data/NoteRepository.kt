package com.example.easynote.data

class NoteRepository(private val noteDao: NoteDao) {

    fun getAllNotes() = noteDao.getAllNotes()
    suspend fun insertNote(note: Note) = noteDao.insertNotes(note = note)
    suspend fun updateNote(note: Note) = noteDao.updateNotes(note)
    suspend fun delete(id: Int) = noteDao.deleteSpecificNote(id)

    fun searchByTitleOrDescription(searchQuery:String) =
        noteDao.searchByTitleOrDescription(searchQuery)

}