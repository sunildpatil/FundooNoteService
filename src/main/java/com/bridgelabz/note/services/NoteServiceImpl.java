package com.bridgelabz.note.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bridgelabz.note.exceptions.NoteException;
import com.bridgelabz.note.models.Note;
import com.bridgelabz.note.models.NoteCreateDTO;
import com.bridgelabz.note.models.NoteResponseDTO;
import com.bridgelabz.note.models.NoteUpdateDTO;
import com.bridgelabz.note.repositories.NoteRepository;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private NoteRepository noteRespository;
	
	@Value("${noteerrormsg}")
	private String noteErrorMsg;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@Override
	public void createNote(NoteCreateDTO noteDTO, int userId) {
				
		Note note = modelMapper.map(noteDTO, Note.class);
		note.setUserId(userId);
		
		Date date = new Date();
		note.setCreatedDate(dateFormat.format(date));
		note.setUpdatedDate(dateFormat.format(date));
		
		noteRespository.save(note);
	}

	@Override
	public void updateNote(NoteUpdateDTO noteUpdateDTO, int userId) throws NoteException {
		
		Note note = noteRespository.findByIdAndUserId(noteUpdateDTO.getId(), userId);
		
		if(note==null) {
			
			throw new NoteException(noteErrorMsg);
		}

		Date date = new Date();
		note.setId(noteUpdateDTO.getId());
		note.setTitle(noteUpdateDTO.getTitle());
		note.setDescription(noteUpdateDTO.getDescription());
		note.setUpdatedDate(dateFormat.format(date));
		note.setUserId(userId);
	
		noteRespository.save(note);
	}

	@Override
	public void deleteNote(int noteId, int userId) throws NoteException {
		
		Note note = noteRespository.findByIdAndUserId(noteId, userId);
		
		if(note==null) {
			
			throw new NoteException(noteErrorMsg);
		}
		
		noteRespository.delete(note);
	}
	
	@Override
	public List<NoteResponseDTO> displayNotes(int userId) throws NoteException {
		
		List<Note> list = noteRespository.findAllNoteByUserId(userId);
		
		if(list==null) {
			
			throw new NoteException(noteErrorMsg);
		}
		
		List<NoteResponseDTO> noteList = new ArrayList<>();

		for(Note noteObject:list) {
			
			NoteResponseDTO noteResponseObject =  modelMapper.map(noteObject, NoteResponseDTO.class);
			noteList.add(noteResponseObject);
		}
					
		return noteList;
	}
}