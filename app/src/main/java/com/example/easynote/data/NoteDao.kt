package com.example.easynote.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getSpecificNote(id: Int): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note: Note) : Long

    @Delete
    suspend fun deleteNotes(note: Note)

    @Query("DELETE FROM note WHERE id = :id")
    suspend fun deleteSpecificNote(id: Int) :Int

    @Update
    suspend fun updateNotes(note: Note) :Int

    @Query("SELECT * FROM note WHERE title LIKE '%' || :searchQuery || '%' ")
    fun searchByTitleOrDescription(searchQuery: String): Flow<List<Note>>



}