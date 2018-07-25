package com.bridgelabz.note.services;

import java.util.List;

import com.bridgelabz.note.exceptions.NoteException;
import com.bridgelabz.note.models.NoteCreateDTO;
import com.bridgelabz.note.models.NoteResponseDTO;
import com.bridgelabz.note.models.NoteUpdateDTO;

public interface NoteService {

	public void createNote(NoteCreateDTO noteDTO, int userId);
	public void updateNote(NoteUpdateDTO noteUpdateDTO, int userId) throws NoteException;
	public void deleteNote(int noteId, int userId) throws NoteException;
	public List<NoteResponseDTO> displayNotes(int userId) throws NoteException;

}