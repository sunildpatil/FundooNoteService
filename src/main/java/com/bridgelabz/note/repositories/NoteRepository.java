package com.bridgelabz.note.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.note.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> { 
		
	public Note findByIdAndUserId(int id, int userId);
	public Note findById(int userId);
	public List<Note> findAllNoteByUserId(int userId);
	
}